package io.roundservice.api.round.controller.dto.res;

import io.roundservice.api.round.domain.dto.out.RoundInfo;
import io.roundservice.common.mapper.ObjectrMapper;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record RoundBeginResponse(
        long id
) implements RoundResponse {

    public static RoundBeginResponse from(RoundInfo roundInfo) {
        return ObjectrMapper.convert(roundInfo, RoundBeginResponse.class);
    }
}
