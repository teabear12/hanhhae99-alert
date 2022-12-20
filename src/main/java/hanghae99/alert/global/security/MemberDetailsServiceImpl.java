package hanghae99.alert.global.security;

import hanghae99.alert.global.exception.CustomErrorCodeEnum;
import hanghae99.alert.global.exception.CustomException;
import hanghae99.alert.member.entity.Member;
import hanghae99.alert.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailsServiceImpl implements UserDetailsService {
    /*
     DB 내 계정정보 유무 검사
      - 사용자 정보를 DB에서 가져오고, UserDetailsImpl 생성자 매개값으로 전달
    */

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new CustomException(CustomErrorCodeEnum.MEMBER_NOT_FOUND)
        );

        return new MemberDetailsImpl(member, member.getUsername(), member.getPassword());
    }
}
