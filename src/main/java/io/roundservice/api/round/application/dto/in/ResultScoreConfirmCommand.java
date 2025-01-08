package io.roundservice.api.round.application.dto.in;

import io.roundservice.common.dto.ScoreDto;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 18.
 */
public record ResultScoreConfirmCommand(
        long partyId,
        long roundId,
        List<ScoreDto> userScoreDtos
) {

    public static ResultScoreConfirmCommand from(long partyId, long roundId, List<ScoreDto> userScoreDtos) {
        return new ResultScoreConfirmCommand(partyId, roundId, userScoreDtos);
    }
}
