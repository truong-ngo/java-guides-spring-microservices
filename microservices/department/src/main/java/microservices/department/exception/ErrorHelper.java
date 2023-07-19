package microservices.department.exception;
import microservices.department.utils.MessageUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ErrorHelper {
    public static ErrorResponse buildErrorObject(String errorKey) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(errorKey);
        errorResponse.setTimestamp(LocalDateTime.now().toString());
        errorResponse.setMessage(MessageUtils.messageSource.getMessage("error." + errorKey, null, LocaleContextHolder.getLocale()));
        return errorResponse;
    }
}
