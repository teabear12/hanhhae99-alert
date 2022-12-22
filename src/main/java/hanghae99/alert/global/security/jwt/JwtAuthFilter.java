package hanghae99.alert.global.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import hanghae99.alert.global.response.Response;
import hanghae99.alert.global.response.ResponseMessage;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtUtil.resolveToken(request);  // JwtUtil 안에 2. header 토큰을 가져오기

        //회원가입, 로그인 시에는 토큰이 없기에 아래처럼 조건문 달아야함
        if (token != null) {
            if (!jwtUtil.validateToken(token)) { //JwtUtil 안에 4. 토큰 검증
                //유효하지 않은 토큰 예외 발생
                Response responseDto = new Response(ResponseMessage.TOKEN_VALUE_INVALID_MSG);

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());

                try (OutputStream os = response.getOutputStream()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.writeValue(os, responseDto);
                    os.flush();
                }
                return; //이거 없으면 콘솔창에 에러 터진거 막 출력됨

            }
            Claims info = jwtUtil.getUserInfoFromToken(token);  //JwtUtil 안에 5. 토큰에서 사용자 정보 가져오기, getBody()를 통해 사용자 정보 가져옴
            setAuthentication(info.getSubject()); //getSubject()로 ID값 가져와서 검증.. 아래 45번줄 setAuthentication()
        }
        filterChain.doFilter(request, response);
    }

    // 인증객체 생성하고 SercurityContextHolder 안에 등록
    public void setAuthentication(String username) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication = jwtUtil.createAuthentication(username); //JwtUtil 안에 만든 - 인증 객체 생성
        context.setAuthentication(authentication);

        SecurityContextHolder.setContext(context);
    }
}
