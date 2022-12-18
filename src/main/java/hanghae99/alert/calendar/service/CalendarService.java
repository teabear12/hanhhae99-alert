package hanghae99.alert.calendar.service;

import hanghae99.alert.calendar.dto.CalendarInfoResponseDto;
import hanghae99.alert.calendar.dto.CalendarSaveRequestDto;

public interface CalendarService {
    void createCalendar(CalendarSaveRequestDto calendarSaveRequestDto, String username);

    CalendarInfoResponseDto getCalendarInfo(String username,Long calendarId);

}
