package io.roundservice.api.round.controller.dto.res.submit;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 13.
 */
public record CheckConfirmResponse(
        long targetId
) implements RoundSubmitResponse {
    public static CheckConfirmResponse from(long targetId) {
        return new CheckConfirmResponse(targetId);
    }
}
