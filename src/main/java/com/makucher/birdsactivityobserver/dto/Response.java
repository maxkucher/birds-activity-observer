package com.makucher.birdsactivityobserver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private int status;
    private String message;
}
