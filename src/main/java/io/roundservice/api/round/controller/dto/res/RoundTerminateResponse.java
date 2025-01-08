package io.roundservice.api.round.controller.dto.res;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 29.
 */
public record RoundTerminateResponse (){

    public static RoundTerminateResponse from() {
        return new RoundTerminateResponse();
    }
}
