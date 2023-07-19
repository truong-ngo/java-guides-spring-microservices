package com.javaguide.restapi.exception;

import lombok.Getter;
import lombok.Setter;

public class BusinessException extends RuntimeException {

    @Getter
    @Setter
    private ErrorResponse response;

    public BusinessException(String errorKey) {
        super();
        setResponse(ErrorHelper.buildErrorObject(errorKey));
    }

    public BusinessException(String errorKey, Object[] params) {
        super();
        setResponse(ErrorHelper.buildErrorObject(errorKey, params));
    }
}
