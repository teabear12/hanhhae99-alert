package hanghae99.alert.member.controller;

import hanghae99.alert.global.response.Response;
import hanghae99.alert.member.dto.MemberLoginRequestDto;
import hanghae99.alert.member.dto.MemberSignupRequestDto;
import hanghae99.alert.member.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static hanghae99.alert.global.response.ResponseMessage.LOGIN_USER_SUCCESS_MSG;
import static hanghae99.alert.global.response.ResponseMessage.SIGNUP_USER_SUCCESS_MSG;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public Response singup(@RequestBody @Valid MemberSignupRequestDto memberSignupRequestDto) {
       memberService.signup(memberSignupRequestDto);
       return new Response(SIGNUP_USER_SUCCESS_MSG);
    }

//    @PostMapping("/login")
//    public String login(@RequestBody MemberSignupRequestDto memberSignupReqDto, HttpServletResponse response){
//        memberService.login(memberSignupReqDto, response);
//    return "success";
//    }

    //로그인까지는 토큰이 없기에 @RequestBody로 값을 받아야 함
    @PostMapping("/login")
    public Response login(@RequestBody MemberLoginRequestDto memberLoginRequestDto, HttpServletResponse response){
        System.out.println("비번 테스트 : " + memberLoginRequestDto.getPassword());
        memberService.login(memberLoginRequestDto, response);
        return new Response(LOGIN_USER_SUCCESS_MSG);
    }
}
