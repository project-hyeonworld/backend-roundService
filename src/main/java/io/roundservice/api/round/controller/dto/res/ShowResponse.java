package io.roundservice.api.round.controller.dto.res;

import io.roundservice.api.round.application.dto.out.GameShowStageResponse;
import io.roundservice.common.mapper.ObjectrMapper;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record ShowResponse(
        String content
) implements RoundResponse {
    public static ShowResponse from(String content) {
        return new ShowResponse(content);
    }
}
