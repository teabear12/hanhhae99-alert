package hanghae99.alert.calendar.dto;


import hanghae99.alert.calendar.entity.Calendar;
import lombok.Getter;

@Getter
public class CalendarInfoResponseDto {

    private String content;

    /* 다듬어야 함 */
    private String startTime;

    /* 다듬어야 함 */
    private String endTime;


    public CalendarInfoResponseDto(Calendar calendar){
        this.content= calendar.getContent();
        this.startTime= String.valueOf(calendar.getStartTime());
        this.endTime = calendar.getEndTime();
    }

}
