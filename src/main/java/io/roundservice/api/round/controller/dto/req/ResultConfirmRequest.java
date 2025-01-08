package io.roundservice.api.round.controller.dto.req;

import io.roundservice.api.round.domain.dto.in.RoundResultConfirmCommand;
import io.roundservice.api.user.application.dto.ScoreDto;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record ResultConfirmRequest(
        List<Participant> participants
) {
    record Participant(
            long id,
            long score
    ) {


    }
    public RoundResultConfirmCommand toCommand(long partyId, long roundId) {
        List<ScoreDto> userScoreDtos = this.participants.stream()
                .map(participant -> new ScoreDto(participant.id(), participant.score()))
                .collect(Collectors.toList());
        return RoundResultConfirmCommand.from(partyId, roundId, userScoreDtos);
    }
}
