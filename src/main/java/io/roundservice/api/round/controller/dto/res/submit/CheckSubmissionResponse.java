package io.roundservice.api.round.controller.dto.res.submit;

import io.roundservice.api.round.client.game.CheckInfo;
import io.roundservice.api.round.client.game.GameCheckStageResponse;
import io.roundservice.api.round.application.dto.out.check.SubmissionInfo;
import io.roundservice.api.round.client.game.check.GameCheckSubmissionResponse;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record CheckSubmissionResponse(
        long userId,
        String name,
        String text,
        String number
) implements RoundSubmitResponse {

    public static List<CheckSubmissionResponse> from(
            CheckInfo checkInfo) {
        if (checkInfo instanceof GameCheckSubmissionResponse) {
            GameCheckSubmissionResponse info = (GameCheckSubmissionResponse) checkInfo;
            return io.roundservice.api.round.controller.dto.res.submit.CheckSubmissionResponse.from(info.userId(), info.name(), info.text(), info.number());
        }

    }

    private static CheckSubmissionResponse from(MiniSubmissionInfo miniSubmissionInfo) {
        return new CheckSubmissionResponse(miniSubmissionInfo.getUserId(), miniSubmissionInfo.getName(), miniSubmissionInfo.getText(), String.valueOf(miniSubmissionInfo.getNumber()));
    }
}
