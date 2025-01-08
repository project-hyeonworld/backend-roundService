package io.roundservice.api.round.event.submit;

import io.roundservice.api.round.event.RoundEvent;
import io.roundservice.common.event.CustomEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 9.
 */
public record SubmitEvent(
        long partyId,
        long userId,
        String text,
        long number
) implements RoundEvent {


    @Override
    public Class<? extends CustomEvent> getEventClass() {
        return RoundEvent.class;
    }

    public static SubmitEvent from(long partyId, long userId, String text, long number) {
        return new SubmitEvent(partyId, userId, text, number);
    }
}
