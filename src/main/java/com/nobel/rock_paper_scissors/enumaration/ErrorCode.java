package com.nobel.rock_paper_scissors.enumaration;

import static com.nobel.rock_paper_scissors.controller.error.ErrorMessage.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  EMAIL_MISSING_IN_HEADER(HttpStatus.BAD_REQUEST, HEADER_MISSING_EMAIL_ERROR),
  CHOICE_NOT_FOUND(HttpStatus.BAD_REQUEST, CHOICE_NOT_FOUND_ERROR),
  USER_NOT_FOUND(HttpStatus.NOT_FOUND, USER_NOT_FOUND_ERROR);

  private final HttpStatus httpStatus;
  private final String messageKey;
}
