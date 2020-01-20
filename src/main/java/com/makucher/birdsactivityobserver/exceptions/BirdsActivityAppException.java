package com.makucher.birdsactivityobserver.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BirdsActivityAppException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public BirdsActivityAppException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
