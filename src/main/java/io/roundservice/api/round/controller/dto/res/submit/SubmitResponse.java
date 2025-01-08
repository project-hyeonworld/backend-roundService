package io.roundservice.api.round.controller.dto.res.submit;

import io.roundservice.api.round.client.game.check.SubmissionInfo;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 11. 4.
 */
public record SubmitResponse(
    long partyId,
    long roundId
) implements RoundSubmitResponse {

  public static SubmitResponse from(SubmissionInfo submissionInfo) {
    return new SubmitResponse(submissionInfo.partyId(), submissionInfo.roundCount());
  }
}