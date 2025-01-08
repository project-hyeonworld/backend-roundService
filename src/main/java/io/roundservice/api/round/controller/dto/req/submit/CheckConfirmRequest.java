package io.roundservice.api.round.controller.dto.req.submit;

import io.roundservice.api.round.domain.dto.in.SubmissionCheckConfirmCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record CheckConfirmRequest(
        long partyId,
        long gameId,
        long roundId,
        long targetId
)implements RoundSubmitRequest {

    public SubmissionCheckConfirmCommand toCommand(long partyId, long roundId) {
        return new SubmissionCheckConfirmCommand(partyId, roundId, gameId, targetId);
    }
}
