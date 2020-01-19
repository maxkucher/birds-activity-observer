package com.makucher.birdsactivityobserver.exceptions;

import org.springframework.http.HttpStatus;

public class BirdsActivityAppException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public BirdsActivityAppException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
