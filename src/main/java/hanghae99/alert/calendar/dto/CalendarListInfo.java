package hanghae99.alert.calendar.dto;

import hanghae99.alert.calendar.entity.Calendar;
import lombok.Getter;

@Getter
public class CalendarListInfo {
    private Long calendarId;
    private String content;

    /*일단 String 타입으로 반환 추후에 FE 분들이 편한 타입으로 변경 */
    private String endTime;

    public CalendarListInfo(Calendar calendar){
        this.calendarId = calendar.getId();
        this.content = calendar.getContent();
        this.endTime = calendar.getEndTime();
    }
}
