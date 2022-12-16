package hanghae99.alert.global.response;

import lombok.Getter;

/* 클래스 이름 수정할 것  */
@Getter
public class ResponseMessage {

    private Enum msg;
    /* null일 경우에 생성자 다른것 만들어서 사용 */
    private Object data;

}
