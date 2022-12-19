package hanghae99.alert.global.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class CustomErrorResponse {
    private final int statusCode;
    private String error;
    private String message;

    public static ResponseEntity<CustomErrorResponse> toResponseEntity(CustomErrorCodeEnum errorCodeEnum) {
        return ResponseEntity
                .status(errorCodeEnum.getHttpStatus())
                .body(CustomErrorResponse.builder()
                        .statusCode(errorCodeEnum.getHttpStatus().value())
                        .error(errorCodeEnum.getHttpStatus().name())
                        .message(errorCodeEnum.getDetail())
                        .build()
                );
    }
}
