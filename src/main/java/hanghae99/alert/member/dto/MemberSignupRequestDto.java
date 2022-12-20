package hanghae99.alert.member.dto;

import hanghae99.alert.member.entity.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@ApiModel(value="회원가입 요청 정보")
@Getter
@NoArgsConstructor
public class MemberSignupRequestDto {

    @ApiModelProperty(value ="회원 아이디", dataType = "String", example = "hong1234")
    @NotBlank(message="아이디를 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9a-z]).{4,10}",message = "아이디는 4~10자 영문 소문자, 숫자를 이용해주세요.")
    private String username;

    @ApiModelProperty(value ="비밀번호", dataType = "String", example = "Abcd1234@")
    @NotBlank(message="비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!#%*?&])[A-Za-z\\d@$!#%*?&]{8,15}$",message = "비밀번호는 8~15자 영문 대 소문자, 숫자, 특수문자를 이용해주세요.")
    private String password;

    @ApiModelProperty(value ="닉네임", dataType = "String", example = "홍길동")
    private String nickname;

    public Member toMember(String username, String password, String nickname) {
        return new Member(
                username,
                password,
                nickname
        );
    }

}
