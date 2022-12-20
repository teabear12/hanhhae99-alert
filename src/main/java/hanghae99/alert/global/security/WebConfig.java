package hanghae99.alert.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import static hanghae99.alert.global.security.jwt.JwtUtil.AUTHORIZATION_HEADER;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry reg) {
        reg.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PATCH", "DELETE")
                .allowedHeaders(AUTHORIZATION_HEADER);
    }
}
/**
 addMapping : CORS적용할 URL패턴
 allowedOrigins("react서버주소") //접근 허용할 주소
 allowedHeaders : 허용한 Method 설정
 */