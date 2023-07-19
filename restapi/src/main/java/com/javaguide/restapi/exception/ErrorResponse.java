package com.javaguide.restapi.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode;
    private String errorDesc;
    private String message;
}
