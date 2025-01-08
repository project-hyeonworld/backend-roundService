package io.roundservice.api.round.application.dto.in;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 11.
 */
public record SubmissionCheckConfirmCommand(
    long partyId,
    long roundCount,
    long gameId,
    long targetId
) {

}
