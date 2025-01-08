package io.roundservice.api.round.controller.dto.res;

import io.roundservice.api.round.client.game.GameResultResponse;
import io.roundservice.common.dto.NameDtos;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record ResultResponse(
        String answer,
        NameDtos winners
) implements RoundResponse {

    public static ResultResponse from(GameResultResponse resultStage) {
        return new ResultResponse(resultStage.answer(), resultStage.winners());
    }
}
