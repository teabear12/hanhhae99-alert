package hanghae99.alert.global.exception;

import lombok.Getter;

/* excep 1. 커스텀 예외 */
@Getter
public class CustomException extends RuntimeException {
    private final CustomErrorCodeEnum errorCode;

    public CustomException(CustomErrorCodeEnum errorCode) { //불필요한 @AllArgsConstructor 사용 방지
        this.errorCode = errorCode;
    }
}
