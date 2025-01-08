package io.roundservice.api.round.controller;

import io.roundservice.api.round.application.RoundReadFacade;
import io.roundservice.api.round.application.RoundWriteFacade;
import io.roundservice.api.round.client.game.check.GameCheckSubmissionResponse;
import io.roundservice.api.round.controller.dto.req.PlayRequest;
import io.roundservice.api.round.controller.dto.req.ResultConfirmRequest;
import io.roundservice.api.round.controller.dto.req.RoundBeginRequest;
import io.roundservice.api.round.controller.dto.req.submit.CheckConfirmRequest;
import io.roundservice.api.round.controller.dto.req.submit.SubmissionRequest;
import io.roundservice.api.round.controller.dto.res.PlayResponse;
import io.roundservice.api.round.controller.dto.res.ResultConfirmResponse;
import io.roundservice.api.round.controller.dto.res.ResultResponse;
import io.roundservice.api.round.controller.dto.res.RoundBasicResponse;
import io.roundservice.api.round.controller.dto.res.RoundBeginResponse;
import io.roundservice.api.round.controller.dto.res.RoundTerminateResponse;
import io.roundservice.api.round.controller.dto.res.ShowResponse;
import io.roundservice.api.round.controller.dto.res.submit.CheckConfirmResponse;
import io.roundservice.api.round.controller.dto.res.submit.SubmitResponse;
import io.roundservice.api.round.domain.RoundService;
import io.roundservice.api.round.domain.dto.in.TerminateRoundCommand;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/parties/{partyId}/rounds")
public class RoundController {

    private final RoundService roundService;
    private final RoundWriteFacade roundWriteFacade;
    private final RoundReadFacade roundReadFacade;

    @GetMapping
    public ResponseEntity<RoundBasicResponse> findByPartyId(@PathVariable long partyId) {
        return ResponseEntity.ok(RoundBasicResponse.from(roundService.retrieveCurrentRound(partyId)));
    }

    @PostMapping
    public ResponseEntity<RoundBeginResponse> beginRound(
            @PathVariable long partyId,
            @RequestBody RoundBeginRequest request) {
        return ResponseEntity.ok(RoundBeginResponse.from(roundService.begin(request.toCommand(partyId))));
    }

    /*
    참가자는 partyId 정보만 알고
    사회자만 partyId, roundId 정보를 관리합니다.
     */
    @PostMapping("/submits")
    public ResponseEntity<SubmitResponse> submit(
            @PathVariable long partyId,
            @RequestBody SubmissionRequest request) {
        return ResponseEntity.ok(
                SubmitResponse.from(roundWriteFacade.submit(request.toCommand(partyId))));
    }

    @GetMapping("/{roundId}/checks")
    public ResponseEntity<List<GameCheckSubmissionResponse>> checkSubmissions(
            @PathVariable long partyId,
            @PathVariable long roundId) {
        return ResponseEntity.ok(roundReadFacade.checkSubmissions(partyId, roundId));
    } //check stage

    @PatchMapping("/{roundId}/check-confirm")
    public ResponseEntity<CheckConfirmResponse> checkSubmissionConfirm(
            @PathVariable long partyId,
            @PathVariable long roundId,
            @RequestBody CheckConfirmRequest request) {
        return ResponseEntity.ok(
                CheckConfirmResponse.from(roundWriteFacade.checkConfirm(request.toCommand(partyId, roundId))));
    }

    @GetMapping("/shows")
    public ResponseEntity<ShowResponse> show(
            @PathVariable long partyId) {
        return ResponseEntity.ok(ShowResponse.from(roundReadFacade.show(partyId)));
    }

    @PatchMapping("/plays")
    public ResponseEntity<PlayResponse> play(
            @PathVariable long partyId,
            @RequestBody PlayRequest request
    ) {
        return ResponseEntity.ok(PlayResponse.from(roundWriteFacade.play(request.toCommand(partyId))));
    }

    @GetMapping("/results")
    public ResponseEntity<ResultResponse> result(
            @PathVariable long partyId
    ) {
        return ResponseEntity.ok(ResultResponse.from(roundReadFacade.result(partyId)));
    }

    @PostMapping("/{roundId}/result-confirm")
    public ResponseEntity<ResultConfirmResponse> resultScore(
            @PathVariable long partyId,
            @PathVariable long roundId,
            @RequestBody ResultConfirmRequest request
    ) {
        roundWriteFacade.resultScoreConfirm(request.toCommand(partyId, roundId));
        return ResponseEntity.ok(
                ResultConfirmResponse.from());
    }

    @DeleteMapping("/{roundId}")
    public ResponseEntity<RoundTerminateResponse> terminateRound(
            @PathVariable long partyId,
            @PathVariable long roundId) {
        roundService.terminate(TerminateRoundCommand.from(partyId, roundId));
        return ResponseEntity.ok(RoundTerminateResponse.from());
    }

}
