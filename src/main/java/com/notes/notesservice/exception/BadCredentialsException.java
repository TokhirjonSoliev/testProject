package com.notes.notesservice.exception;

import com.notes.notesservice.exception.config.ApiRequestException;
import org.springframework.http.HttpStatus;

public class BadCredentialsException extends ApiRequestException {
    public BadCredentialsException(String message) {
        super(message, HttpStatus.UNAUTHORIZED.value());
    }
}

