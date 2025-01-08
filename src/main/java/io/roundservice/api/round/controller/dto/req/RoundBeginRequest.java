package io.roundservice.api.round.controller.dto.req;

import io.roundservice.api.round.domain.dto.in.BeginRoundCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record RoundBeginRequest(long partyId,
                    Long gameId
) implements RoundRequest {

    public BeginRoundCommand toCommand(long partyId) {
        return new BeginRoundCommand(partyId, gameId);
    }
}
