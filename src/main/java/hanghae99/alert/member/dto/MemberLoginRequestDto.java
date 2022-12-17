package hanghae99.alert.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberLoginRequestDto {
    private String username;
    private String password;

    //Dto -> Entity, 빌더 사용(호진)
    public MemberLoginRequestDto toMemberLoginDto(){
        return MemberLoginRequestDto.builder()
                .username(username)
                .password(password)
                .build();
    }
}
