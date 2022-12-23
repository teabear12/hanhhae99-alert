package hanghae99.alert.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String msg;
    private int statusCode;

    public Response(ResponseMessage responseMessage) {
        this.msg = responseMessage.getMsg();
        this.statusCode = responseMessage.getStatus();
    }

    public Response(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
