package io.roundservice.api.round.application;

import io.roundservice.api.round.client.game.GameCheckStageResponse;
import io.roundservice.api.round.client.game.GameClient;
import io.roundservice.api.round.client.game.GameResultResponse;
import io.roundservice.api.round.client.game.ResultInfo;
import io.roundservice.api.round.client.game.check.GameCheckSubmissionResponse;
import io.roundservice.api.round.domain.RoundService;
import io.roundservice.api.round.domain.dto.out.RoundInfo;
import io.roundservice.common.annotation.Facade;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 14.
 */
@Facade
@RequiredArgsConstructor
public class RoundReadFacade {

    private final RoundService roundService;
    private final GameClient gameClient;

    @Transactional
    public List<GameCheckSubmissionResponse> checkSubmissions(long partyId, long roundCount) {
        RoundInfo roundInfo = roundService.retrieveCurrentRound(partyId);
        return gameClient.checkStage(roundInfo.getGameId(), partyId, roundCount);
    }

    public String show(long partyId) {
        RoundInfo roundInfo = roundService.retrieveCurrentRound(partyId);
        long targetId = roundService.getTargetId(partyId, roundInfo.getRoundCount());
        return gameClient.showStage(roundInfo.getGameId(), partyId, roundInfo.getRoundCount(), targetId);
    }

    public GameResultResponse result(long partyId) {
        RoundInfo roundInfo = roundService.retrieveCurrentRound(partyId);
        long targetId = roundService.getTargetId(partyId, roundInfo.getRoundCount());
        return gameClient.resultStage(partyId, roundInfo.getRoundCount(), targetId);
    }



}
