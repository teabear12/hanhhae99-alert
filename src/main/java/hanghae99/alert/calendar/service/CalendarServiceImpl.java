package hanghae99.alert.calendar.service;

import hanghae99.alert.calendar.dto.CalendarListInfo;
import hanghae99.alert.calendar.dto.CalendarListInfoResponseDto;
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
        Member member = checkMember(username);
        Calendar calendar = calendarSaveRequestDto.toEntity(System.currentTimeMillis(),member.getId());
        calendarRepository.save(calendar);
    }
    
    /* 일정 전체 조회 */
    @Override
    public CalendarListInfoResponseDto getCalendarListInfo(String username) {
        CalendarListInfoResponseDto calendarList = new CalendarListInfoResponseDto();
        Member member = checkMember(username);
        for(Calendar calendar : member.getCalendarList()){
            calendarList.addCalendar(new CalendarListInfo(calendar));
        }
        return calendarList;
    }

    /* 일정 상세 조회 */
    @Override
    @Transactional(readOnly = true)
    public CalendarInfoResponseDto getCalendarInfo(String username,Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        return new CalendarInfoResponseDto(calendar);
    }

    /* 일정 수정 */
    @Override
    @Transactional
    public void updateCalendar(CalendarSaveRequestDto request, String username, Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        calendar.update(request.getContent(),request.getEndTime());
    }

    /* 일정 삭제 */
    @Override
    @Transactional
    public void deleteCalendar(String username, Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        calendarRepository.delete(calendar);
    }

    /* 일정 확인 */
    private Calendar checkCalendar(Long calendarId){
        return calendarRepository.findById(calendarId).orElseThrow(()-> new IllegalArgumentException("존재하지 않은 게시물입니다."));
    }

    /* 유저 확인 */
    private Member checkMember(String username){
        return memberRepository.findByUsername(username).orElseThrow(()-> new IllegalArgumentException("로그인이 필요합니다."));
    }

}
