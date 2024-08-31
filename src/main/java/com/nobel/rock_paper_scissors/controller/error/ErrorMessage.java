package com.nobel.rock_paper_scissors.controller.error;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
  public static final String ERROR_INTERNAL_SERVER = "error.internal_server";

  public static final String HEADER_MISSING_EMAIL_ERROR = "User email should exists in x-email header";

  public static final String CHOICE_NOT_FOUND_ERROR = "User choice type doesn't exists";

  public static final String USER_NOT_FOUND_ERROR = "User with email doesn't exists";
}
