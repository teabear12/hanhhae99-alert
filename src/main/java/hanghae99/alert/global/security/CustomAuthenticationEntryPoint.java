package hanghae99.alert.global.security;

import hanghae99.alert.global.exception.CustomErrorCodeEnum;
import hanghae99.alert.global.exception.CustomErrorResponse;
import hanghae99.alert.global.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint { //토큰 인증 예외처리
    // 인증과정에서 실패하거나 인증헤더(Authorization)를 보내지 않게되는 경우 401(UnAuthorized) 라는 응답값을 받게되는데요.
    //인증되지 않은 사용자의 리소스에 대한 접근 처리는 AuthenticationEntryPoint가 담당
    //이를 처리해주는 로직이 바로 AuthenticationEntryPoint라는 인터페이스
    //Response에 401이 떨어질만한 에러가 발생할 경우 해당로직을 타게되어, commence라는 메소드를 실행

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        response.setContentType("application/json; charset=utf8");
        response.getWriter().println("Oh my god!! 한글되나요");//new CustomException(CustomErrorCodeEnum.UNAUTHORIZED_TOKEN));
        //throw new CustomException(CustomErrorCodeEnum.UNAUTHORIZED_TOKEN);

    }


}
