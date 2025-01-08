package io.roundservice.api.round.domain.dto.in;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 29.
 */
public record TerminateRoundCommand(
        long partyId,
        long roundCount
) {
    public static TerminateRoundCommand from(long partyId, long roundCount) {
        return new TerminateRoundCommand(partyId, roundCount);
    }
}
