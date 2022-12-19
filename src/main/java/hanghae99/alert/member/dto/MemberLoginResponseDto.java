package hanghae99.alert.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginResponseDto {
    private String nickname;

    public MemberLoginResponseDto(String nickname) {
        this.nickname = nickname;
    }
}
