package hanghae99.alert.member.dto;

import hanghae99.alert.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignupRequestDto {

    private String username;

    //비밀번호 형식 검사 - 영어대소문자, 숫자, 특수문자 무조건 1개씩 입력, 길이 8자이상 15자이하
    //예외 발생 안되서 주석처리함]]]]]]]]]
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!#%*?&])[A-Za-z\\d@$!#%*?&]{8,15}$")
    private String password;

    private String nickname;

    //Dto -> Entity
    public Member toMember(String username, String password, String nickname) {
        return new Member(
                username,
                password,
                nickname
        );
    }

}
