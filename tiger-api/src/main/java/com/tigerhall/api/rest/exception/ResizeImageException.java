package com.tigerhall.api.rest.exception;

public class ResizeImageException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ResizeImageException(String message) {
    super(message);
  }

  public ResizeImageException(String message, Throwable cause) {
    super(message, cause);
  }
}
