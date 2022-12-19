package hanghae99.alert.member.dto;

import lombok.Getter;

@Getter
public class MemberLoginResponseDto {
    private String nickname;

    public MemberLoginResponseDto(String nickname) {
        this.nickname = nickname;
    }
}
