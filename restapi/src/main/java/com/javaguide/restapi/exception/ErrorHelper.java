package com.javaguide.restapi.exception;
import com.javaguide.restapi.utils.MessageUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ErrorHelper {
    public static ErrorResponse buildErrorObject(String errorKey) {
        return buildErrorObject(errorKey, null);
    }

    public static ErrorResponse buildErrorObject(String errorKey, Object[] params) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(errorKey);
        errorResponse.setMessage(MessageUtils.messageSource.getMessage("error." + errorKey, params, LocaleContextHolder.getLocale()));
        return errorResponse;
    }
}
