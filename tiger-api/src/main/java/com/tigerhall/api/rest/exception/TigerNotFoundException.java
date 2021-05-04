package com.tigerhall.api.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TigerNotFoundException extends RuntimeException {

    public TigerNotFoundException(String message) {
        super(message);
    }
}
