package hanghae99.alert.global.security;

import hanghae99.alert.global.security.dto.MemberRoleEnum;
import hanghae99.alert.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MemberDetailsImpl implements UserDetails{
    private final Member member;
    private final String username;

    private final String password;

    //생성자
    public MemberDetailsImpl(Member member, String username, String password) {
        this.member = member;
        this.username = username;
        this.password = password;
    }

    //게터
    public Member getMember(){
        return member;
    }

    // Member의 권한을 가져오고, Collection에 넣어서 반환함.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //MemberRoleEnum role = member.getRole();
        MemberRoleEnum role = MemberRoleEnum.MEMBER;  //현재 우리는 일반 회원만 구현할거니까, 하드코딩
        String authority = role.getAuthority();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
