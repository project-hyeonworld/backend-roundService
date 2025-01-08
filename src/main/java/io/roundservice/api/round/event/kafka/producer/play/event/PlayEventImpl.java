package io.roundservice.api.round.event.kafka.producer.play.event;

import io.roundservice.api.round.event.submission.SubmissionEvent;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 12.
 */

public record PlayEventImpl(
        long partyId,
        long roundCount,
        long gameId,
        long userId,
        String answer
) implements SubmissionEvent {

    public static SubmissionEvent from(long partyId, long partyRoundId, long gameId, long userId, String answer) {
        return new PlayEventImpl(partyId, partyRoundId, gameId, userId, answer);
    }
}
