package io.roundservice.api.round.infrastructure.jdbc;

import io.roundservice.api.round.infrastructure.entity.Round;
import io.roundservice.common.exception.ServerException;
import io.roundservice.common.exception.dto.ServerResponseCode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
@Repository
@RequiredArgsConstructor
public class RoundJdbcTemplateRepositoryImpl implements RoundjdbcTemplateRepository {
  private final JdbcTemplate jdbcTemplate;

  public Round insert(Round round) {
    String selectSql = "SELECT COALESCE(MAX(round_count), 0) + 1 FROM round WHERE party_id = ?";
    long maxRoundCount = jdbcTemplate.queryForObject(selectSql, Long.class, round.getPartyId());
    String sql = "INSERT INTO round (party_id, game_id, created_at, round_count) " +
            "VALUES (?, ?, ?, ?)";
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ps.setLong(1, round.getPartyId());
      if (round.getGameId() == null) {
        ps.setLong(2, Types.BIGINT);
      }
      if (round.getGameId() != null) {
        ps.setLong(2, round.getGameId());
      }
      if (round.getCreatedAt() != null) {
        ps.setTimestamp(3, Timestamp.valueOf(round.getCreatedAt()));
      }
      ps.setLong(4, maxRoundCount);

      return ps;
    });
    round.setRoundCount(maxRoundCount);
    return round;
  }

  @Override
  public Optional<Round> findById(long partyId, long roundCount) {
    return Optional.empty();
  }

  public Round update(Round round) {
    StringBuilder sql = new StringBuilder("UPDATE round SET");
    List<Object> params = new ArrayList<>();
    boolean needComma = false;
    if (round.getTargetId() != null){
      sql.append(" target_id = ?");
      params.add(round.getTargetId());
      needComma = true;
    }

    if (params.isEmpty()) {
      return round;
    }
    sql.append(" WHERE party_id = ?");
    params.add(round.getPartyId());
    sql.append(" AND round_count = ?");
    params.add(round.getRoundCount());
    try {
      int updatedRows = jdbcTemplate.update(sql.toString(),
          params.toArray());

      if (updatedRows == 0) {
      }
      return round;
    } catch (DataAccessException e) {
      throw new RuntimeException("Failed to update round", e);
    }
  }

  public Round save(Round round) {
    return Optional.ofNullable(round.getRoundCount())
        .map(id -> update(round))
        .orElseGet(() -> insert(round));
  }

  public Optional<Round> findByPartyId(long partyId) {
    String sql = "SELECT * FROM round WHERE party_id = ? ORDER BY created_at DESC LIMIT 1";
    return jdbcTemplate.query(sql, this::mapRowToRound, partyId)
        .stream()
        .findFirst();
  }

  @Override
  public void terminateAll() {
    String sql = "UPDATE round SET terminated_at = NOW() WHERE terminated_at IS NULL";
    int updatedRows = jdbcTemplate.update(sql);
  }

  @Override
  public void terminate(long partyId, long roundCount) {
    String sql = "UPDATE round SET terminated_at = NOW() WHERE party_id = ? AND round_count = ?";
    try {
      int updatedRows = jdbcTemplate.update(sql, partyId, roundCount);
      if (updatedRows == 0) {
        throw new ServerException(ServerResponseCode.UPDATE_FAIL);
      }
    } catch (DataAccessException e) {
      throw new RuntimeException("Failed to update round", e);
    }
  }

  private Round mapRowToRound(ResultSet rs, int rowNum) throws SQLException {
    Round round = new Round();
    round.setRoundCount(rs.getLong("round_count"));
    round.setPartyId(rs.getLong("party_id"));
    round.setGameId(rs.getLong("game_id"));
    round.setTargetId(rs.getLong("target_id"));
    if (rs.getTimestamp("created_at") != null) {
      round.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
    }

    return round;
  }
}
