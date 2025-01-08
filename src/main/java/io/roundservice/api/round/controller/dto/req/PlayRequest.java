package io.roundservice.api.round.controller.dto.req;

import io.roundservice.api.round.domain.dto.in.RoundPlayCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record PlayRequest(
        long userId,
        String answer
) implements RoundRequest {

    public RoundPlayCommand toCommand(long partyId) {
        return new RoundPlayCommand(partyId, userId, answer);
    }

}
