package io.roundservice.api.round.controller.dto.res;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record ResultConfirmResponse(

) implements RoundResponse {


    public static ResultConfirmResponse from() {
        return new ResultConfirmResponse();
    }
}