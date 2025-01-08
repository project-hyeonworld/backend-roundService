package io.roundservice.api.round.infrastructure;

import io.roundservice.api.round.infrastructure.entity.Round;
import io.roundservice.api.round.infrastructure.entity.RoundId;
import io.roundservice.api.round.infrastructure.jdbc.RoundjdbcTemplateRepository;
import io.roundservice.api.round.infrastructure.jpa.RoundJpaRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
@Repository
@Primary
@RequiredArgsConstructor
public class RoundRepositoryImpl implements RoundRepository {
  private final RoundJpaRepository roundJpaRepository;
  private final RoundjdbcTemplateRepository roundJdbcTemplateRepository;

  @Override
  public Round insert(Round round) {
    return roundJdbcTemplateRepository.insert(round);
  }

  @Override
  public Optional<Round> findById(long partyId, long roundCount) {
    return roundJpaRepository.findById(RoundId.from(partyId, roundCount));
  }

  @Override
  public Round update(Round round) {
    return roundJdbcTemplateRepository.update(round);
  }

  @Override
  public Optional<Round> findByPartyId(long partyId) {
    return roundJdbcTemplateRepository.findByPartyId(partyId);
  }

  @Override
  public void terminateAll() {
    roundJdbcTemplateRepository.terminateAll();
  }

  @Override
  public void terminate(long partyId, long roundCount) {
    roundJdbcTemplateRepository.terminate(partyId, roundCount);
  }
}
