package hanghae99.alert.global.security;

public interface TeamTwoRequest {
    Long getMemberId();
}
////3. 비밀번호 확인(외부에서 넘어온 사용자가 입력한 비번, DB저장된 비번)
//            if(!passwordEncoder.matches(password, userDetails.getPassword())) {
//                    throw new IllegalAccessError("비밀번호가 일치하지 않습니다.");
//                    }