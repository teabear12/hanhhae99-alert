package hanghae99.alert.calendar.service;

import hanghae99.alert.calendar.dto.CalendarListInfo;
import hanghae99.alert.calendar.dto.CalendarListInfoResponseDto;
import hanghae99.alert.calendar.dto.CalendarSaveRequestDto;
import hanghae99.alert.calendar.entity.Calendar;
import hanghae99.alert.calendar.repository.CalendarRepository;
import hanghae99.alert.global.exception.CustomErrorCodeEnum;
import hanghae99.alert.global.exception.CustomException;
import hanghae99.alert.member.entity.Member;
import hanghae99.alert.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;
    private final MemberRepository memberRepository;

    /* 일정 저장 */
    @Override
    public void createCalendar(CalendarSaveRequestDto calendarSaveRequestDto, String username) {
        Member member = checkMember(username);
        Calendar calendar = calendarSaveRequestDto.toEntity(System.currentTimeMillis(),member.getId());
        calendarRepository.save(calendar);
    }
    
    /* 일정 전체 조회 */
    @Override
    @Transactional(readOnly = true)
    public CalendarListInfoResponseDto getCalendarListInfo(String username) {
        CalendarListInfoResponseDto calendarList = new CalendarListInfoResponseDto();
        Member member = checkMember(username);
        List<Calendar> calendars = calendarRepository.findByMemberIdOrderByEndTimeAsc(member.getId());
        for(Calendar calendar : calendars){
            /* 마감시간이 지나지 않았다면 true로 UPDATE */
            if(isDone(calendar.getEndTime())){calendar.updateDone(true);}
            calendarList.addCalendar(new CalendarListInfo(calendar));
        }
        return calendarList;
    }

    /* 일정 수정 */
    @Override
    public void updateCalendar(CalendarSaveRequestDto request, String username, Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        calendar.updateCalendar(request.getContent(),request.getEndTime());
    }

    /* 일정 삭제 */
    @Override
    public void deleteCalendar(String username, Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        calendarRepository.delete(calendar);
    }

    /* 일정 확인 */
    private Calendar checkCalendar(Long calendarId){
        return calendarRepository.findById(calendarId).orElseThrow(()-> new CustomException(CustomErrorCodeEnum.CALENDAR_NOT_FOUND));
    }

    /* 유저 확인 */
    private Member checkMember(String username){
        return memberRepository.findByUsername(username).orElseThrow(()->new CustomException(CustomErrorCodeEnum.MEMBER_NOT_FOUND));
    }

    /* 마감시간과 현재시간 비교 */
    private boolean isDone(Long endTime){
        return (endTime>System.currentTimeMillis());
    }
}
