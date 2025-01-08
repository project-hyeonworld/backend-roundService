package io.roundservice.api.round.event.kafka.producer.resultConfirm.event;

import io.roundservice.api.round.event.RoundEvent;
import io.roundservice.common.dto.ScoreDto;
import io.roundservice.common.event.CustomEvent;
import java.util.List;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 9.
 */
public record ResultConfirmEvent(
        long partyId,
        long roundCount,
        List<ScoreDto> participants

) implements RoundEvent {

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return ResultConfirmEvent.class;
    }

//    public static ScoreEvent from(ResultScoreConfirmCommand command) {
//        return new ScoreResultConfirmEvent(command.partyId(), command.roundId(), command.userScoreDtos());
//    }

    public static ResultConfirmEvent from(long partyId, long roundCount, List<ScoreDto> participants) {
        return new ResultConfirmEvent(partyId, roundCount, participants);
    }


}



public interface ExitGameEvent<T extends Message> extends IngameEvent {

    static ExitGameEvent<?> from(long userId, long partyId, String userName) {
        return new ExitGameEventImpl(userId, partyId, userName);
    }
}