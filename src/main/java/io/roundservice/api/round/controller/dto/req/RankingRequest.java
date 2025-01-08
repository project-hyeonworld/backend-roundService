package io.roundservice.api.round.controller.dto.req;

import io.roundservice.api.round.domain.dto.in.RoundRankingCommand;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record RankingRequest(
        long partyId,
        long roundId
)
        implements RoundRequest {

    public RoundRankingCommand toCommand() {
        return new RoundRankingCommand(partyId, roundId);
    }

}