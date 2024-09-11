package com.mysite.sbb.workout.record;

import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.workout.routine.Routine;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Long 타입의 자동 생성 ID

    @Column(name = "workoutdate")
    private String workoutDate;

    @ManyToOne
    @JoinColumn(name = "routinename", referencedColumnName = "routinename") // ��래 ���로 사용
    private Routine routinename;
    
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username") // 외래 키로 사용
    private SiteUser siteUser;

    public Record() {
    }

    public Record(String workoutDate, Routine routinename , SiteUser siteUser) {
        this.workoutDate = workoutDate;
        this.siteUser = siteUser;
        this.routinename = routinename;

    }
    


}
