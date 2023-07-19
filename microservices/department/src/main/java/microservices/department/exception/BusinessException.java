package microservices.department.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BusinessException extends RuntimeException {
    private ErrorResponse response;

    public BusinessException(String errorKey) {
        super();
        setResponse(ErrorHelper.buildErrorObject(errorKey));
    }
}
