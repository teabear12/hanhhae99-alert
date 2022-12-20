package hanghae99.alert.calendar.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Calendar{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "calendar_id")
    private Long id;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private Long startTime;
    @Column(nullable = false)
    private Long endTime;
    @Column(nullable = false)
    private boolean done;
    @Column(name="member_id")
    private Long memberId;

    public void updateCalendar(String content, Long endTime){
        this.content = content;
        this.endTime = endTime;
    }
    public void updateDone(boolean done){
        this.done = done;
    }

    @Builder
    public Calendar (String content,Long startTime,Long endTime, Long memberId){
        this.content = content;
        this.startTime=startTime;
        this.endTime = endTime;
        this.memberId = memberId;
    }

}
