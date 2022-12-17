package hanghae99.alert.global.response;

import lombok.Getter;

@Getter
public enum ResponseMessage {

    // calendar
    READ_CALENDAR_SUCCESS_MSG(200, "일정 정보 조회 성공"),
    READ_PAGING_POSTING_SUCCESS_MSG(200, "일정 정보 페이징 조회 성공"),
    CREATE_CALENDAR_SUCCESS_MSG(201, "일정 생성 성공 "),
    UPDATE_CALENDAR_SUCCESS_MSG(201,"일정 수정 성공"),
    DELETE_CALENDAR_SUCCESS_MSG(200,"일정 삭제 성공"),

    // user
    SIGNUP_USER_SUCCESS_MSG(201, "유저 회원가입 성공 "),
    LOGIN_USER_SUCCESS_MSG(201, "유저 로그인 성공 "),
    USER_DELETE_SUCCESS_MSG(201, "회원 탈퇴 성공 ");

    private final int status;
    private final String msg;
    ResponseMessage(final int status, final String msg) {
        this.status = status;
        this.msg = msg;
    }
}
