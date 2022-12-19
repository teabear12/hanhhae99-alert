package hanghae99.alert.calendar.dto;


import hanghae99.alert.calendar.entity.Calendar;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class CalendarInfoResponseDto {
    private String content;
    private String startTime;
    private String endTime;

    public CalendarInfoResponseDto(Calendar calendar){
        this.content= calendar.getContent();
        this.startTime= changeMillisToDate(calendar.getStartTime());
        this.endTime = changeMillisToDate(calendar.getEndTime());
    }

    /* 초 단위를 날짜 형식으로 바꿈 */
    private String changeMillisToDate(Long millis){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd hh시 mm분");
        return dateFormat.format(new Date(millis));
    }

}
