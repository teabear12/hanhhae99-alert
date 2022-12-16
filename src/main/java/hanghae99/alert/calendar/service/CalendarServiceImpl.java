package hanghae99.alert.calendar.service;

import hanghae99.alert.calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;
    @Override
    public void calendarSave() {
    }
}
