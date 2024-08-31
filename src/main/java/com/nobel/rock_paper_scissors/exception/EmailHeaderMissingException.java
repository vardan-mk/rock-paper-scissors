package com.nobel.rock_paper_scissors.exception;

import com.nobel.rock_paper_scissors.enumaration.ErrorCode;

public class EmailHeaderMissingException extends BaseException {

  public EmailHeaderMissingException () {
    super(ErrorCode.EMAIL_MISSING_IN_HEADER);
  }
}