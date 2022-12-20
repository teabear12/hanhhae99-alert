package hanghae99.alert.calendar.repository;

import hanghae99.alert.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByMemberIdOrderByEndTimeAsc(Long memberId);
}
