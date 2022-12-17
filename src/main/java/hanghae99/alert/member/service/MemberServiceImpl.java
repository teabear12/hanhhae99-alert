package hanghae99.alert.member.service;

import hanghae99.alert.global.exception.CustomErrorCodeEnum;
import hanghae99.alert.global.exception.CustomException;
import hanghae99.alert.member.dto.MemberSignupRequestDto;
import hanghae99.alert.member.entity.Member;
import hanghae99.alert.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void signup(MemberSignupRequestDto memberSignupRequestDto) {
        Member member = memberSignupRequestDto.toMember(memberSignupRequestDto);
        memberRepository.save(member);
    }
}
