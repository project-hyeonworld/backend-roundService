package io.roundservice.api.round.application;

import io.roundservice.api.round.application.dto.in.SubmitCommand;
import io.roundservice.api.round.client.game.check.SubmissionInfo;
import io.roundservice.api.round.domain.RoundService;
import io.roundservice.api.round.domain.dto.in.RoundPlayCommand;
import io.roundservice.api.round.domain.dto.in.RoundResultConfirmCommand;
import io.roundservice.api.round.domain.dto.in.SubmissionCheckConfirmCommand;
import io.roundservice.api.round.domain.dto.out.RoundInfo;
import io.roundservice.api.round.event.score.ScoreResultConfirmEvent;
import io.roundservice.api.round.event.submission.AnswerSubmissionEvent;
import io.roundservice.api.round.event.submission.PrimarySubmissionEvent;
import io.roundservice.api.round.event.submission.SubmissionEventPublisher;

import io.roundservice.common.annotation.Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 7.
 */
@Facade
@RequiredArgsConstructor
public class RoundWriteFacade {

    private final RoundService roundService;
    private final GameService gameService;
    private final SubmissionEventPublisher submissionEventPublisher;

    @Transactional
    public SubmissionInfo submit(SubmitCommand command) {
        RoundInfo roundInfo = roundService.retrieveCurrentRound(command.partyId());
        submissionEventPublisher.execute(PrimarySubmissionEvent.from(command, roundInfo.getRoundCount()));
        return SubmissionInfo.from(command.partyId(), roundInfo.getRoundCount());
    }

    public void resultScoreConfirm(RoundResultConfirmCommand command) {
        scoreEventPublisher.execute(ScoreResultConfirmEvent.from(command));
    }

    @Transactional
    public long checkConfirm(SubmissionCheckConfirmCommand command) {
        GameStrategy gameStrategy = gameService.getGame(command.gameId());
        return gameStrategy.checkConfirm(command);
    }

    @Transactional
    public PlayInfo play(RoundPlayCommand command) {
        RoundInfo roundInfo = roundService.retrieveCurrentRound(command.partyId());
        submissionEventPublisher.execute(
                AnswerSubmissionEvent.from(command.partyId(), roundInfo.getRoundCount(), roundInfo.getGameId(),
                        command.userId(), command.answer()));
        return PlayInfo.from(command);
    }
}
