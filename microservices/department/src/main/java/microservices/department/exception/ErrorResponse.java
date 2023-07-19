package microservices.department.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode;
    private String timestamp;
    private String message;
    private String path;
}
