package hanghae99.alert.calendar.controller;

import hanghae99.alert.calendar.dto.CalendarInfoResponseDto;
import hanghae99.alert.calendar.dto.CalendarListInfoResponseDto;
import hanghae99.alert.calendar.dto.CalendarSaveRequestDto;
import hanghae99.alert.calendar.service.CalendarService;
import hanghae99.alert.global.response.DataResponse;
import hanghae99.alert.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static hanghae99.alert.global.response.ResponseMessage.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendars")
public class CalendarController {
    private final CalendarService calendarService;
    /* 일정 등록 */
    @PostMapping
    public Response createCalendar(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CalendarSaveRequestDto request) {
        String username = userDetails.getUsername();
        calendarService.createCalendar(request,username);
        return new Response(CREATE_CALENDAR_SUCCESS_MSG);
    }
    /* 일정 전체 조회 */
    @GetMapping
    public DataResponse<CalendarListInfoResponseDto> getCalendarListInfo(@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        CalendarListInfoResponseDto response = calendarService.getCalendarListInfo(username);
        return new DataResponse<>(READ_CALENDAR_LIST_SUCCESS_MSG, response);
    }
    /* 일정 상세 조회 */
    @GetMapping("/{calendarId}")
    public DataResponse<CalendarInfoResponseDto> getCalendarInfo(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long calendarId){
        String username = userDetails.getUsername();
        CalendarInfoResponseDto response = calendarService.getCalendarInfo(username,calendarId);
        return new DataResponse<>(READ_CALENDAR_SUCCESS_MSG, response);
    }
    /* 일정 수정 */
    @PatchMapping("/{calendarId}")
    public Response updateCalendar(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CalendarSaveRequestDto request, @PathVariable Long calendarId ) {
        String username = userDetails.getUsername();
        calendarService.updateCalendar(request,username,calendarId);
        return new Response(UPDATE_CALENDAR_SUCCESS_MSG);
    }
    /* 일정 삭제 */
    @DeleteMapping("/{calendarId}")
    public Response deleteCalendar(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long calendarId) {
        String username = userDetails.getUsername();
        calendarService.deleteCalendar(username,calendarId);
        return new Response(DELETE_CALENDAR_SUCCESS_MSG);
    }
}
