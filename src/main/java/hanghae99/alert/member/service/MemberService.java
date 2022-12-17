package hanghae99.alert.member.service;

import hanghae99.alert.member.dto.MemberLoginRequestDto;
import hanghae99.alert.member.dto.MemberSignupRequestDto;

import javax.servlet.http.HttpServletResponse;

public interface MemberService {
    void signup(MemberSignupRequestDto memberSignupRequestDto);

    //    void login(MemberSignupRequestDto memberSignupRequestDto, HttpServletResponse response);
    void login(MemberLoginRequestDto memberLoginRequestDto, HttpServletResponse response);
}
