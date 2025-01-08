package io.roundservice.api.round.client.game;

import io.roundservice.api.round.client.game.check.GameCheckSubmissionResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 7.
 */
@FeignClient(name = "game-service", url = "${my.feign-client.game-service.address}"+":${my.feign-client.game-service.port}"+"${my.feign-client.game-service.end-point}")
public interface GameClient {

    @GetMapping("/{gameId}/checks")
    List<GameCheckSubmissionResponse> checkStage(@PathVariable long gameId,
            @RequestParam long partyId,
            @RequestParam long roundCount);

    @GetMapping("/{gameId}/shows")
    String showStage(@PathVariable long gameId,
            @RequestParam long partyId,
            @RequestParam long roundCount,
            @RequestParam long targetId);

    @GetMapping("/{gameId}/results")
    GameResultResponse resultStage(@PathVariable long gameId,
            @RequestParam long partyId,
            @RequestParam long roundCount);
}