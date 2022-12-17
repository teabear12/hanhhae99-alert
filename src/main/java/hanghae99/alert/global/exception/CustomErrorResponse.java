package hanghae99.alert.global.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class CustomErrorResponse {
    //private LocalDateTime timestamp = LocalDateTime.now();
    private final int status;
    private String error;
    private String code;
    private String message;

    public static ResponseEntity<CustomErrorResponse> toResponseEntity(CustomErrorCodeEnum errorCodeEnum) {
        return ResponseEntity
                .status(errorCodeEnum.getHttpStatus())
                .body(CustomErrorResponse.builder()
                        .status(errorCodeEnum.getHttpStatus().value())
                        .error(errorCodeEnum.getHttpStatus().name())
                        .code(errorCodeEnum.getDetail())
                        .message(errorCodeEnum.getDetail())
                        .build()
                );
    }
}
