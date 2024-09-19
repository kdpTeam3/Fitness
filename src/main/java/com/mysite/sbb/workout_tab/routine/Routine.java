package com.mysite.sbb.workout_tab.routine;

import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.workout_tab.workout.Workout;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser siteUser;

    @Column(nullable = false)
    private String routine_name;

    @OneToMany(mappedBy = "routine"  , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Workout> workouts;

    public Routine(){}

    public Routine(SiteUser siteUser, String routine_name) {
        this.siteUser = siteUser;
        this.routine_name = routine_name;
    }
}
