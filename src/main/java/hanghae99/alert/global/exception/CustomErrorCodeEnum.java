package hanghae99.alert.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

/* excep 2. 커스텀 예외 Enum */
@Getter
@AllArgsConstructor
public enum CustomErrorCodeEnum {
    /* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_PASSWORD(BAD_REQUEST, "비밀번호 형식이 유효하지 않습니다."),
    INCORRECT_PASSWORD(BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    CALENDAR_NOT_FOUND(BAD_REQUEST,"존재하지 않는 일정입니다."),

    /* 401 UNAUTHORIZED : 안증되지 않았거나, 유효한 인증정보 부족 */
    UNAUTHORIZED_TOKEN(UNAUTHORIZED, "인증 정보가 유효하지 않습니다."),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    MEMBER_NOT_FOUND(NOT_FOUND, "해당 유저 정보를 찾을 수 없습니다"),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    DUPLICATE_USERNAME(CONFLICT, "중복된 유저이름입니다.");

    private final HttpStatus httpStatus;
    private final String detail;
}
