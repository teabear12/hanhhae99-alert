package hanghae99.alert.calendar.dto;

import java.util.ArrayList;
import java.util.List;

public class CalendarListInfoResponseDto {

    private static final List<CalendarListInfo> calendarList = new ArrayList<>();

    /* 리스트에 값 추가 */
    public void addCalendar(CalendarListInfo calendarListInfo){calendarList.add(calendarListInfo);}
}
