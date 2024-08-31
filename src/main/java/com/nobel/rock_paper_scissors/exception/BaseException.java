package com.nobel.rock_paper_scissors.exception;

import com.nobel.rock_paper_scissors.enumaration.ErrorCode;

public abstract class BaseException extends RuntimeException {
  private final ErrorCode errorCode;
  private final String messageKey;

  protected BaseException(ErrorCode errorCode) {
    super(errorCode.getMessageKey());
    this.errorCode = errorCode;
    this.messageKey = errorCode.getMessageKey();
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }

  @Override
  public String getMessage() {
    return messageKey;
  }
}