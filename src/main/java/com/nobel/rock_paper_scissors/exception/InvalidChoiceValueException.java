package com.nobel.rock_paper_scissors.exception;

import com.nobel.rock_paper_scissors.enumaration.ErrorCode;

public class InvalidChoiceValueException extends BaseException {

  public InvalidChoiceValueException() {
    super(ErrorCode.CHOICE_NOT_FOUND);
  }
}