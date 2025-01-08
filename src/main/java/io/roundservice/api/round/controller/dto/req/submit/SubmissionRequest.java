package io.roundservice.api.round.controller.dto.req.submit;

import io.roundservice.api.round.application.dto.in.SubmitCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record SubmissionRequest (
                                 long userId,
                                 String text,
                                 Long number

) implements RoundSubmitRequest {
    public SubmitCommand toCommand(long partyId) {
        return new SubmitCommand(partyId, userId, text, number);
    }
}
