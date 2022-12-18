package hanghae99.alert.calendar.service;

import hanghae99.alert.calendar.dto.CalendarInfoResponseDto;
import hanghae99.alert.calendar.dto.CalendarSaveRequestDto;
import hanghae99.alert.calendar.entity.Calendar;
import hanghae99.alert.calendar.repository.CalendarRepository;
import hanghae99.alert.member.entity.Member;
import hanghae99.alert.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;
    private final MemberRepository memberRepository;

    /* 일정 저장 */
    @Override
    @Transactional
    public void createCalendar(CalendarSaveRequestDto calendarSaveRequestDto, String username) {
        checkMember(username);
        Calendar calendar = calendarSaveRequestDto.toEntity();
        calendarRepository.save(calendar);
    }

    /* 일정 삭제 */
    @Override
    @Transactional
    public void deleteCalendar(String username, Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        calendarRepository.delete(calendar);
    }
    
    /* 일정 전체 조회 */



    /* 일정 상세 조회 */
    @Override
    @Transactional(readOnly = true)
    public CalendarInfoResponseDto getCalendarInfo(String username,Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        return new CalendarInfoResponseDto(calendar);
    }


    @Override
    @Transactional
    public void updateCalendar(CalendarSaveRequestDto request, String username, Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        calendar.update(request.getContent(),request.getEndTime());
    }


    private Calendar checkCalendar(Long calendarId){
        return calendarRepository.findById(calendarId).orElseThrow(()-> new IllegalArgumentException("존재하지 않은 게시물입니다."));
    }

    private Member checkMember(String username){
        return memberRepository.findByUsername(username).orElseThrow(()-> new IllegalArgumentException("로그인이 필요합니다."));
    }


}
