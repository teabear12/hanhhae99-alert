package hanghae99.alert.member.dto;

import hanghae99.alert.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignupRequestDto {

    private String username;
    private String nickname;
    private String password;

    public Member toMember(MemberSignupRequestDto memberSignupRequestDto) {
        return new Member(memberSignupRequestDto.getUsername(),
                memberSignupRequestDto.getNickname(),
                memberSignupRequestDto.getPassword() );
    }
}
