package hanghae99.alert.calendar.controller;

import hanghae99.alert.calendar.dto.CalendarSaveRequestDto;
import hanghae99.alert.calendar.service.CalendarService;
import hanghae99.alert.global.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static hanghae99.alert.global.response.ResponseMessage.CREATE_CALENDAR_SUCCESS_MSG;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendars")
public class CalendarController {

    private final CalendarService calendarService;
    /* 일정 등록 */
    @PostMapping
    public Response createCalendar(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CalendarSaveRequestDto calendarSaveRequestDto) {
        String username = userDetails.getUsername();
        calendarService.createCalendar(calendarSaveRequestDto);
        return new Response(CREATE_CALENDAR_SUCCESS_MSG);
    }



    /* 일정 전체 조회 */



    /* 일정 상세 조회 */



    /* 일정 수정 */



    /* 일정 삭제 */




}
