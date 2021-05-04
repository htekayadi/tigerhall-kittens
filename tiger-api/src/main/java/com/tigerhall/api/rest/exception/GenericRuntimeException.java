package com.tigerhall.api.rest.exception;

public class GenericRuntimeException extends RuntimeException {
  public GenericRuntimeException(String message) {
    super(message);
  }

  public GenericRuntimeException(Throwable cause) {
    super(cause);
  }
}
