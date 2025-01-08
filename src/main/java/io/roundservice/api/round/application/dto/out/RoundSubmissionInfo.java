package io.roundservice.api.round.application.dto.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 25. 1. 7.
 */
@Getter
@NoArgsConstructor
public class RoundSubmissionInfo {

    private long userId;
    private String name;
    private String text;
    private long number;

    private RoundSubmissionInfo(long userId, String userName, String text, Long number) {
        this.userId = userId;
        this.name = userName;
        this.text = text;
        this.number = number;
    }

    public static RoundSubmissionInfo from(long userId, String userName, String text, Long number) {
        return new RoundSubmissionInfo(userId, userName, text, number);
    }
}
