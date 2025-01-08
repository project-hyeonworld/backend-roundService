package io.roundservice.api.round.event.kafka.producer.resultConfirm;

import io.roundservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEvent;
import io.roundservice.api.session.event.kafka.producer.ingame.enterGame.event.EnterGameEventImpl;
import io.roundservice.common.event.CustomEvent;
import io.roundservice.common.event.kafka.producer.message.Message;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 12. 18.
 */
public class EnterGameMessage implements EnterGameEvent, Message {

    private final long userId;
    private final long partyId;
    private final String userName;

    private EnterGameMessage(long userId, long partyId, String userName) {
        this.userId = userId;
        this.partyId = partyId;
        this.userName = userName;
    }

    public static EnterGameMessage from(EnterGameEvent event) {
        EnterGameEventImpl impl = (EnterGameEventImpl) event;
        return new EnterGameMessage(impl.userId(), impl.partyId(), impl.userName());
    }

    @Override
    public long userId() {
        return userId;
    }

    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return EnterGameEvent.class;
    }

    @Override
    public EnterGameEventRecord getRecordValue() {
        return new EnterGameEventRecord(partyId, userName);
    }
}
