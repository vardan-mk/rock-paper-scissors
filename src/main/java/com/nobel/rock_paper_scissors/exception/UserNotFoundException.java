package com.nobel.rock_paper_scissors.exception;

import com.nobel.rock_paper_scissors.enumaration.ErrorCode;

public class UserNotFoundException extends BaseException {

  public UserNotFoundException() {
    super(ErrorCode.USER_NOT_FOUND);
  }
}
