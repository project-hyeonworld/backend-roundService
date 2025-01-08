package io.roundservice.api.round.controller.dto.req;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 24.
 */
public record RoundBasicRequest (
        long partyId
)
        implements RoundRequest{

}
