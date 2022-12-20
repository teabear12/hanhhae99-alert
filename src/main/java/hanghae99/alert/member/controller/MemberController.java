package hanghae99.alert.member.controller;

import hanghae99.alert.global.exception.CustomErrorCodeEnum;
import hanghae99.alert.global.exception.CustomException;
import hanghae99.alert.global.response.DataResponse;
import hanghae99.alert.global.response.Response;
import hanghae99.alert.member.dto.MemberLoginRequestDto;
import hanghae99.alert.member.dto.MemberLoginResponseDto;
import hanghae99.alert.member.dto.MemberSignupRequestDto;
import hanghae99.alert.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static hanghae99.alert.global.response.ResponseMessage.LOGIN_USER_SUCCESS_MSG;
import static hanghae99.alert.global.response.ResponseMessage.SIGNUP_USER_SUCCESS_MSG;
@Api(tags={"회원 API Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {
    private final MemberService memberService;
    @ApiOperation(value="회원가입")
    @PostMapping("/signup")
    public Response singup(@RequestBody @Valid MemberSignupRequestDto memberSignupRequestDto, BindingResult result) {
        if(result.hasErrors()){
            throw new CustomException(CustomErrorCodeEnum.INVALID_PASSWORD);
        }

        memberService.signup(memberSignupRequestDto);
        return new Response(SIGNUP_USER_SUCCESS_MSG);
    }
    @ApiOperation(value="로그인")
    @PostMapping("/login")
    public DataResponse<MemberLoginResponseDto> login(@RequestBody MemberLoginRequestDto memberLoginRequestDto, HttpServletResponse response){
        MemberLoginResponseDto nickname = memberService.login(memberLoginRequestDto, response);
        return new DataResponse<>(LOGIN_USER_SUCCESS_MSG, nickname);
    }
}
