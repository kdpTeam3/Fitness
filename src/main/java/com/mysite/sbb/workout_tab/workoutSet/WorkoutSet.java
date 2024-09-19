package com.mysite.sbb.workout_tab.workoutSet;

import com.mysite.sbb.workout_tab.workout.Workout;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WorkoutSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Integer reps;

    public WorkoutSet(){}

    public WorkoutSet(Workout workout, Integer weight, Integer reps) {
        this.workout = workout;
        this.weight = weight;
        this.reps = reps;
    }

}
