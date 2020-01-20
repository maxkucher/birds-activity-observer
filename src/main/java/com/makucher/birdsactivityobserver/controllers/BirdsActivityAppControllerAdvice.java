package com.makucher.birdsactivityobserver.controllers;


import com.makucher.birdsactivityobserver.dto.Response;
import com.makucher.birdsactivityobserver.exceptions.BirdsActivityAppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BirdsActivityAppControllerAdvice {
    @ExceptionHandler({BirdsActivityAppException.class})
    public ResponseEntity<?> handleBirdsActivityAppException(BirdsActivityAppException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new Response(ex.getStatus().value(), ex.getMessage()));
    }
}
