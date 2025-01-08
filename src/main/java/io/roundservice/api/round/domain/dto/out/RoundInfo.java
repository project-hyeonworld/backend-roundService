package io.roundservice.api.round.domain.dto.out;

import io.roundservice.api.round.domain.dto.in.BeginRoundCommand;
import io.roundservice.api.round.domain.dto.in.TerminateRoundCommand;
import io.roundservice.api.round.infrastructure.entity.Round;
import io.roundservice.common.mapper.ObjectrMapper;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoundInfo {
  private long partyId;
  private long roundCount;
  private Long targetId;
  private long gameId;

  private static Round.RoundBuilder initializeEntity(){
    return Round.builder();
  }

  public static Round create (BeginRoundCommand command){
    if (command.partyId() == -1) {
      return null;
    }
    return initializeEntity()
        .partyId(command.partyId())
        .gameId(command.gameId())
        .createdAt(LocalDateTime.now())
        .build();
  }

  public static Round create (TerminateRoundCommand command){
    if (command.partyId() == -1) {
      return null;
    }
    return initializeEntity()
            .partyId(command.partyId())
            .roundCount(command.roundCount())
            .build();
  }

  public static RoundInfo from (Round round) {
    return ObjectrMapper.convert(round, RoundInfo.class);
  }

  public static Long getTargetId(Round round) {
    return round.getTargetId();
  }

  public Round entityToUpdateTargetId(long targetId) {
    return initializeEntity()
        .partyId(partyId)
        .roundCount(roundCount)
        .targetId(targetId)
        .build();
  }
}
