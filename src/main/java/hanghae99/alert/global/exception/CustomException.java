package hanghae99.alert.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/* excep 1. 커스텀 예외 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final CustomErrorCodeEnum errorCode;
}
