package com.example.siliconvalley_prvtd_lmtd.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String  statusCode;
    private String message;


    public ErrorResponse(String  statusCode,String message) {
        this.statusCode = statusCode;
        this.message = message;

    }

}
