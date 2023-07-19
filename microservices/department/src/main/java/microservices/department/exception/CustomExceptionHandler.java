package microservices.department.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
@RestController
@Order(value = PriorityOrdered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handlerBusinessException(BusinessException ex, WebRequest webRequest) {
        log.warn(String.format("errorType: %s, errorMessage: %s", ex.getClass().getSimpleName(), ex.getMessage()));
        ErrorResponse response = ex.getResponse();
        response.setPath(webRequest.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
