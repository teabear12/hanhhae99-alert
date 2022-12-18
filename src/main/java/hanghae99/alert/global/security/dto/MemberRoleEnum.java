package hanghae99.alert.global.security.dto;

import lombok.Getter;

@Getter
public enum MemberRoleEnum {
    MEMBER(Authority.MEMBER),  // 사용자 권한
    ADMIN(Authority.ADMIN);  // 관리자 권한

    // Member의 권한을 String 값으로 사용하기 위함
    private final String authority;

    MemberRoleEnum(String authority) {
        this.authority = authority;
    }

    public static class Authority {
        public static final String MEMBER = "ROLE_MEMBER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}
