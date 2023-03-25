package com.notes.notesservice.exception;

import com.notes.notesservice.exception.config.ApiRequestException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiRequestException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND.value());
    }
}

