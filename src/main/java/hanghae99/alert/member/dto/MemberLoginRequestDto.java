package hanghae99.alert.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
@ApiModel(value="로그인 요청 정보")
@Getter
public class MemberLoginRequestDto {
    @ApiModelProperty(value ="회원 아이디", dataType = "String", example = "hong1234")
    private String username;
    @ApiModelProperty(value ="비밀번호", dataType = "String", example = "Abcd1234@")
    private String password;
}