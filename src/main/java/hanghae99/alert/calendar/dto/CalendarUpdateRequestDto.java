package hanghae99.alert.calendar.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
@ApiModel(value = "일정 수정 정보")
@Getter
public class CalendarUpdateRequestDto {

    @ApiModelProperty(value="일정 내용", dataType = "String", example="내용")
    private String content;
    @ApiModelProperty(value="마감 시간", dataType = "Long", example="1671436584761")
    private String endTime;
}
