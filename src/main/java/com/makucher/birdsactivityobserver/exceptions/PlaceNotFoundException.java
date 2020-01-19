package com.makucher.birdsactivityobserver.exceptions;

import org.springframework.http.HttpStatus;

public class PlaceNotFoundException extends BirdsActivityAppException {

    public PlaceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
