package hanghae99.alert.global.response;

import lombok.Getter;

@Getter
public enum ResponseMessage {

    // calendar
    READ_CALENDAR_SUCCESS_MSG(200, "일정 정보 상세 조회 성공"),
    READ_CALENDAR_LIST_SUCCESS_MSG(200, "일정 정보 전체 조회 성공"),
    CREATE_CALENDAR_SUCCESS_MSG(200, "일정 생성 성공 "),
    UPDATE_CALENDAR_SUCCESS_MSG(200,"일정 수정 성공"),
    DELETE_CALENDAR_SUCCESS_MSG(200,"일정 삭제 성공"),

    // user
    SIGNUP_USER_SUCCESS_MSG(200, "유저 회원가입 성공 "),
    LOGIN_USER_SUCCESS_MSG(200, "유저 로그인 성공 "),
    USER_DELETE_SUCCESS_MSG(200, "회원 탈퇴 성공 "),

    TOKEN_KEY_MISSING_MSG(401, "헤더에 토큰 키 값이 존재하지 않습니다."),
    TOKEN_VALUE_INVALID_MSG(401, "유효하지 않은 토큰입니다.");




    private final int status;
    private final String msg;
    ResponseMessage(final int status, final String msg) {
        this.status = status;
        this.msg = msg;
    }
}
