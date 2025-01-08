package io.roundservice.api.round.domain;

import static io.roundservice.api.round.domain.dto.out.RoundInfo.*;

import io.roundservice.api.round.domain.dto.in.BeginRoundCommand;
import io.roundservice.api.round.domain.dto.in.TerminateRoundCommand;
import io.roundservice.api.round.domain.dto.out.RoundInfo;
import io.roundservice.api.round.infrastructure.RoundRepository;
import io.roundservice.common.exception.ServerException;
import io.roundservice.common.exception.dto.ServerResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
@Service
@RequiredArgsConstructor
public class RoundService {

    private final RoundRepository roundRepository;

    @CacheEvict(cacheNames = "roundInfo", key = "#command.partyId")
    public RoundInfo begin(BeginRoundCommand command) {
        return from(roundRepository.insert(create(command)));
    }

    public void terminate(TerminateRoundCommand command) {
        roundRepository.terminate(command.partyId(), command.roundCount());
    }

    @Cacheable(cacheNames = "roundInfo", cacheManager = "caffeineCacheManager")
    public RoundInfo retrieveCurrentRound(long partyId) {
        return from(roundRepository.findByPartyId(partyId)
                .orElseThrow(() -> new ServerException(ServerResponseCode.ROUND_NOT_FOUND)));
    }

    public RoundInfo updateAnswerInternal(long partyId, long partyRoundId, long targetId) {
        RoundInfo roundInfo = from(roundRepository.findById(partyId, partyRoundId)
                .orElseThrow(() -> new ServerException(ServerResponseCode.ROUND_NOT_FOUND)));
        return from(roundRepository.update(roundInfo.entityToUpdateTargetId(targetId)));
    }

    @CacheEvict(cacheNames = "roundTargetId", key = "#partyId" + '-' + "#partyRoundId", beforeInvocation = true)
    public RoundInfo updateTargetId(long partyId, long partyRoundId, long targetId) {
        return updateAnswerInternal(partyId, partyRoundId, targetId);
    }

    @Cacheable(cacheNames = "roundTargetId", key = "#partyId" + '-' + "#partyRoundId")
    public long getTargetId(long partyId, long partyRoundId) {
        return RoundInfo.getTargetId(roundRepository.findById(partyId, partyRoundId)
                .orElseThrow(() -> new ServerException(ServerResponseCode.ROUND_NOT_FOUND)));
    }


}
