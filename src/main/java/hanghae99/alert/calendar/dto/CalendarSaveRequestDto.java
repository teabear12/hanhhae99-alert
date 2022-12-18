package hanghae99.alert.calendar.dto;

import hanghae99.alert.calendar.entity.Calendar;
import lombok.Getter;

@Getter
public class CalendarSaveRequestDto {

    private String content;

    private Long endTime;

    private Long memberId;

    /* username이 필요할경우 추가 */
    public Calendar toEntity(Long startTime, Long memberId){
        return Calendar.builder().content(content).startTime(startTime).endTime(endTime).memberId(memberId).build();
    }
}
