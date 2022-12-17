package hanghae99.alert.calendar.dto;

import hanghae99.alert.calendar.entity.Calendar;
import lombok.Getter;

@Getter
public class CalendarSaveRequestDto {

    private String content;

    private String endTime;

    /* username이 필요할경우 추가 */
    public Calendar toEntity(){
        return Calendar.builder().content(content).endTime(endTime).build();
    }
}
