package com.exampl.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParameterNotSpecifiedException extends RuntimeException {
    public ParameterNotSpecifiedException() {
        super();
    }

    public ParameterNotSpecifiedException(String message) {
        super(message);
    }

    public ParameterNotSpecifiedException(String message, Throwable cause) {
        super(message, cause);
    }
}