package io.roundservice.api.round.controller.dto.res;

import io.roundservice.api.round.domain.dto.out.RoundInfo;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 24.
 */
public record RoundBasicResponse (
        long roundId
) implements RoundResponse {

    public static RoundBasicResponse from(RoundInfo roundInfo) {
        return new RoundBasicResponse(roundInfo.getRoundCount());
    }
}
