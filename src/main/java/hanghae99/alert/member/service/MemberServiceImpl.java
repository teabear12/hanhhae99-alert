package hanghae99.alert.member.service;

import hanghae99.alert.member.dto.MemberLoginResponseDto;
import hanghae99.alert.member.dto.MemberSignupRequestDto;
import hanghae99.alert.member.entity.Member;
import hanghae99.alert.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    @Override
    public void signup(MemberSignupRequestDto memberSignupRequestDto) {
        Member member = memberSignupRequestDto.toMember(memberSignupRequestDto);
        memberRepository.save(member);
    }
    @Transactional
    @Override
    public void login(MemberSignupRequestDto memberSignupRequestDto, HttpServletResponse response) {
        String username = memberSignupRequestDto.getUsername();
        String password = memberSignupRequestDto.getPassword();

        Member member = (Member) memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("일치하는 사용자 없다는 메시지")
        );
        if(!member.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않는다는 메시지.");
        }
    }
}
