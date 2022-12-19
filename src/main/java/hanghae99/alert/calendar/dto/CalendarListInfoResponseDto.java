package hanghae99.alert.calendar.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CalendarListInfoResponseDto {
    private final List<CalendarListInfo> calendarList = new ArrayList<>();
    /* 리스트에 값 추가 */
    public void addCalendar(CalendarListInfo calendarListInfo){calendarList.add(calendarListInfo);}
}
