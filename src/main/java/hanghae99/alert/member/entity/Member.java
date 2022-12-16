package hanghae99.alert.member.entity;

import hanghae99.alert.calendar.entity.Calendar;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String nickname;

    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_id")
    private List<Calendar> calendarList = new ArrayList<>();

}
