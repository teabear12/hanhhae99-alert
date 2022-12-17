package hanghae99.alert.calendar.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


@Getter
@Entity
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Calendar {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "calendar_id")
    private Long id;

    private String content;

    private String endTime;

    public void update(String content, String endTime){
        this.content = content;
        this.endTime = endTime;
    }

    @Builder
    public Calendar (String content,String endTime){
        this.content = content;
        this.endTime = endTime;
    }

}
