package io.roundservice.api.round.client.game.check;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 8.
 */
public record GameCheckSubmissionResponse(
        long userId,
        String name,
        String text,
        long number
) {
}