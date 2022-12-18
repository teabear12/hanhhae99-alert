package hanghae99.alert.member.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class Validator {
    public boolean isValidPassword(String password){
        final int MIN = 8;
        final int MAX = 15;

        // 영어, 숫자, 특수문자 조합
        // ?=.* 는 [] 안의 값이 1개는 들어가야 한다는 뜻
        final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!#%*?&])[A-Za-z\\d@$!#%*?&]{" + MIN + "," + MAX + "}$";

        return Pattern.matches(REGEX, password);
    }
}
