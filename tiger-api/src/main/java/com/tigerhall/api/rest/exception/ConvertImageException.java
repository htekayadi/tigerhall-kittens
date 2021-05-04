package com.tigerhall.api.rest.exception;

public class ConvertImageException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ConvertImageException(String message) {
    super(message);
  }

  public ConvertImageException(String message, Throwable cause) {
    super(message, cause);
  }
}
