package hanghae99.alert.calendar.service;

import hanghae99.alert.calendar.dto.CalendarSaveRequestDto;
import hanghae99.alert.calendar.entity.Calendar;
import hanghae99.alert.calendar.repository.CalendarRepository;
import hanghae99.alert.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void createCalendar(CalendarSaveRequestDto calendarSaveRequestDto, String username) {
        checkMember(username);
        Calendar calendar = calendarSaveRequestDto.toEntity();
        calendarRepository.save(calendar);
    }

    @Override
    @Transactional
    public void deleteCalendar(String username, Long calendarId) {
        checkMember(username);
        Calendar calendar = checkCalendar(calendarId);
        calendarRepository.delete(calendar);
    }

    private Calendar checkCalendar(Long calendarId){
        return calendarRepository.findById(calendarId).orElseThrow(()-> new IllegalArgumentException("존재하지 않은 게시물입니다."));
    }

    private void checkMember(String username){
        memberRepository.findByUsername(username).orElseThrow(()-> new IllegalArgumentException("로그인이 필요합니다."));
    }


}
