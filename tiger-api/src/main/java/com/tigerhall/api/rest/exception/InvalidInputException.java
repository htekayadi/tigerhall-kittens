package com.tigerhall.api.rest.exception;

public class InvalidInputException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvalidInputException(String message) {
    super(message);
  }

  public InvalidInputException(String message, Throwable cause) {
    super(message, cause);
  }
}
