package io.roundservice.api.round.interfaces;

import io.roundservice.api.round.event.score.ScoreEvent;
import io.roundservice.api.round.event.score.ScoreRankingEvent;
import io.roundservice.api.round.event.score.ScoreResultConfirmEvent;
import io.roundservice.common.event.EventListener;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 28.
 */
public interface coreEventListener extends EventListener<ScoreEvent> {
    void handleResultConfirmEvent(ScoreResultConfirmEvent event);
    void handleScoreRankingEvent(ScoreRankingEvent event);
}
