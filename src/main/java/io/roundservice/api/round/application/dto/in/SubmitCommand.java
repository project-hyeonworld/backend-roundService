package io.roundservice.api.round.application.dto.in;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 7.
 */
public record SubmitCommand(
        long partyId,
        long userId,
        String text,
        long number
) {

}