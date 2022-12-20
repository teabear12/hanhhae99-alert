package hanghae99.alert.calendar.dto;

import hanghae99.alert.calendar.entity.Calendar;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class CalendarListInfo {
    private Long calendarId;
    private String content;

    private Long endTime;
    private Long currentTimeMillis;
    private Long endTimeMillis;
    private String endTime;
    private String startTime;
    private Boolean done;

    public CalendarListInfo(Calendar calendar){
        this.calendarId = calendar.getId();
        this.content = calendar.getContent();
        this.endTime = calendar.getEndTime();
        this.currentTimeMillis = System.currentTimeMillis();
        this.endTimeMillis = calendar.getEndTime();
        this.startTime=changeMillisToDate(calendar.getStartTime());
        this.endTime=changeMillisToDate(calendar.getEndTime());
        this.done = calendar.getDone();
    }

    private String changeMillisToDate(Long millis){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd hh시 mm분");
        return dateFormat.format(new Date(millis));
    }
}
