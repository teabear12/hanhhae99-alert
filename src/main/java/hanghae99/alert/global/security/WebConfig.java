package hanghae99.alert.global.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry reg){
        reg.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PATCH", "DELETE");
    }
}
/**
 addMapping : CORS적용할 URL패턴
 allowedOrigins("react서버주소") //접근 허용할 주소
 allowedHeaders : 허용한 Method 설정
 */