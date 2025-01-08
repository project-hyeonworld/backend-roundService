package io.roundservice.api.round.controller.dto.res;

import io.roundservice.api.round.application.dto.out.PlayInfo;
import io.roundservice.common.mapper.ObjectrMapper;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record PlayResponse(
        long userId
) implements RoundResponse {

    public static PlayResponse from(PlayInfo playInfo) {
        return ObjectrMapper.convert(playInfo, PlayResponse.class);
    }
}
