package io.roundservice.common.exception.dto;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author : hyeonwoody@gmail.com
 * @since : 24. 8. 29.
 */
@Getter
@RequiredArgsConstructor
public enum ServerResponseCode {
  USER_NOT_FOUND(NOT_FOUND, "The user is not in DB"),

  USER_ALREADY_LOGGED_IN(CONFLICT, "The user is already Logged in"),
  PARTY_ALREADY_TERMINATED(CONFLICT, "The party is already over"),

  PARTY_NOT_FOUND(NOT_FOUND, "The party is not in DB"),

  PARTY_DASHBOARD_NOT_FOUND(NOT_FOUND, "The party-dashboard is not in DB"),

  ROUND_NOT_FOUND(NOT_FOUND, "The round is not in DB"),

  UPDATE_FAIL(NOT_FOUND, "DB update failed"),

  SUBMISSION_NOT_FOUND(NOT_FOUND, "The submission is not in DB");



  private final HttpStatus httpStatus;
  private final String message;
}
