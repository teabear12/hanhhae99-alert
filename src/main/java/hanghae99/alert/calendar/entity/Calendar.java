package hanghae99.alert.calendar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Entity
@NoArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "calendar_id")
    private Long id;

    private String content;

    private LocalDateTime startTime;

    private LocalDateTime endTime;


}
