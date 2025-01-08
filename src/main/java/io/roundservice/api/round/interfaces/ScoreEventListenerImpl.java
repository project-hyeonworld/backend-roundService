package io.roundservice.api.round.interfaces;


import io.roundservice.api.round.event.score.ScoreEvent;
import io.roundservice.api.round.event.score.ScoreRankingEvent;
import io.roundservice.api.round.event.score.ScoreResultConfirmEvent;
import io.roundservice.api.score.domain.ScoreService;
import io.roundservice.api.scoreHistory.domain.ScoreHistoryService;
import io.roundservice.api.scoreHistory.domain.dto.out.ScoreHistoryInfos;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 28.
 */
@Component
@RequiredArgsConstructor
public class ScoreEventListenerImpl implements ScoreEventListener{

    private final ScoreService scoreService;
    private final ScoreHistoryService scoreHistoryService;

    @Override
    @EventListener
    public void handleEvent(ScoreEvent event) {
        if (event instanceof ScoreResultConfirmEvent) {
            handleResultConfirmEvent((ScoreResultConfirmEvent) event);
        }
    }

    @Override
    public void handleResultConfirmEvent(ScoreResultConfirmEvent event) {
//        scoreHistoryService.updateScore(event.partyId(), event.roundId(), event.participants());
//        ScoreHistoryInfos scoreHistoryInfos = scoreHistoryService.retrieveSumScores(event.partyId());
//        scoreService.save(event.partyId(), scoreHistoryInfos);
    }

    @Override
    public void handleScoreRankingEvent(ScoreRankingEvent event) {
        scoreService.save(event.partyId(), event.userScores());
    }
}
