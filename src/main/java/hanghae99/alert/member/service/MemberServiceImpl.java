package hanghae99.alert.member.service;

import hanghae99.alert.global.exception.CustomErrorCodeEnum;
import hanghae99.alert.global.exception.CustomException;
import hanghae99.alert.global.security.dto.MemberRoleEnum;
import hanghae99.alert.global.security.jwt.JwtUtil;
import hanghae99.alert.member.dto.MemberLoginRequestDto;
import hanghae99.alert.member.dto.MemberLoginResponseDto;
import hanghae99.alert.member.dto.MemberSignupRequestDto;
import hanghae99.alert.member.entity.Member;
import hanghae99.alert.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    @Transactional
    @Override
    public void signup(MemberSignupRequestDto memberSignupRequestDto) {
        //1. 회원가입 관련 필드 준비
        String username = memberSignupRequestDto.getUsername();
        String password = memberSignupRequestDto.getPassword();
        String nickname = memberSignupRequestDto.getNickname();

        //2. ID 중복검사 - username
        //ifPresent()는 Optional 객체가 값을 가지고 있으면 실행 값이 없으면 넘어감
        memberRepository.findByUsername(username).ifPresent(m -> {
            throw new CustomException(CustomErrorCodeEnum.DUPLICATE_USERNAME);
        });

        //3. 비밀번호 암호화
        password = passwordEncoder.encode(password);

        //4. Dto -> Entity
        Member member = memberSignupRequestDto.toMember(username, password, nickname);

        //5. 회원가입
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    @Override
    public MemberLoginResponseDto login(MemberLoginRequestDto memberLoginRequestDto, HttpServletResponse response) {
        /* 1. 로그인 관련 필드 준비 */
        String username = memberLoginRequestDto.getUsername();
        String password = memberLoginRequestDto.getPassword();

        /* 2. 회원 존재 여부 확인 */
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new CustomException(CustomErrorCodeEnum.MEMBER_NOT_FOUND)
        );

        //3. 비밀번호 일치 여부 검사
        if (!passwordEncoder.matches(password, member.getPassword())) { // 사용자 입력값 vs DB 저장된 암호
            throw new CustomException(CustomErrorCodeEnum.INCORRECT_PASSWORD);
        }

        //4. Token 생성 및 발급
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(username, MemberRoleEnum.MEMBER));

        //5. 닉네임 결과 반환
        return new MemberLoginResponseDto(member.getNickname());

    }
}
