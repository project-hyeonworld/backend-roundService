package io.roundservice.api.round.domain.dto.in;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 9. 6.
 */
public record BeginRoundCommand (
    long partyId,
    Long gameId
){

}
