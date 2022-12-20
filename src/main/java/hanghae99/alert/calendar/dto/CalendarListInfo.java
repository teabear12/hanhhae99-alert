package hanghae99.alert.calendar.dto;

import hanghae99.alert.calendar.entity.Calendar;
import lombok.Getter;

@Getter
public class CalendarListInfo {
    private Long calendarId;
    private String content;
    private Long endTime;
    private Boolean done;

    public CalendarListInfo(Calendar calendar){
        this.calendarId = calendar.getId();
        this.content = calendar.getContent();
        this.endTime = calendar.getEndTime();
        this.done = calendar.getDone();
    }
}
