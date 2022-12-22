package hanghae99.alert.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry reg) {
        reg.addMapping("/**")
                .allowedOrigins("https://alert-fe-try.vercel.app/")
                .allowedOrigins("http://alertservicefe.s3-website.ap-northeast-2.amazonaws.com/")
                .allowedMethods("GET", "POST", "PATCH", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("Authorization");
    }
}
/**
 addMapping : CORS적용할 URL패턴 ex) "/api/**"
 allowedOrigins("react서버주소") //접근 허용할 주소 ex) http://192.168.4.215:3000
 allowedMethods : 요청 허용할 Method 설정
 allowedHeaders
 exposedHeaders : Front response에 표시할 헤더 명시
 */