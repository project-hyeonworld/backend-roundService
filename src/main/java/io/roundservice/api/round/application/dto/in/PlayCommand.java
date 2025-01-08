package io.roundservice.api.round.application.dto.in;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
public record PlayCommand(
    long partyId,
    long userId,
    String answer
){

}
