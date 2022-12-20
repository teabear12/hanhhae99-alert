package hanghae99.alert.calendar.dto;

import hanghae99.alert.calendar.entity.Calendar;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
@ApiModel(value = "일정 등록 정보")
@Getter
public class CalendarSaveRequestDto {
    @ApiModelProperty(value="일정 내용", dataType = "String", example="내용")
    private String content;
    @ApiModelProperty(value="일정 마감 시간", dataType = "Long", example="1671436584761")
    private Long endTime;
    public Calendar toEntity(Long startTime, Long memberId){
        return Calendar.builder().content(content).startTime(startTime).endTime(endTime).memberId(memberId).build();
    }
}
