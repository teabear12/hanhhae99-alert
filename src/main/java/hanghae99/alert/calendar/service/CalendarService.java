package hanghae99.alert.calendar.service;

import hanghae99.alert.calendar.dto.CalendarListInfoResponseDto;
import hanghae99.alert.calendar.dto.CalendarSaveRequestDto;

public interface CalendarService {
    void createCalendar(CalendarSaveRequestDto calendarSaveRequestDto, String username);
    CalendarListInfoResponseDto getCalendarListInfo(String username);
    void deleteCalendar(String username, Long calendarId);
    void updateCalendar(CalendarSaveRequestDto calendarSaveRequestDto, String username, Long calendarId);
}
