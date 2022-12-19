package hanghae99.alert.member.service;

import hanghae99.alert.member.dto.MemberLoginRequestDto;
import hanghae99.alert.member.dto.MemberLoginResponseDto;
import hanghae99.alert.member.dto.MemberSignupRequestDto;

import javax.servlet.http.HttpServletResponse;

public interface MemberService {
    void signup(MemberSignupRequestDto memberSignupRequestDto);
    MemberLoginResponseDto login(MemberLoginRequestDto memberLoginRequestDto, HttpServletResponse response);
}
