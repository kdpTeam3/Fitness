package com.mysite.sbb.workout_tab.workoutSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkoutSetUpdateDto {
    private Long id;
    private Integer weight;
    private Integer reps;

    public WorkoutSetUpdateDto(){
    }

    public WorkoutSetUpdateDto(Long id, Integer weight, Integer reps){
        this.id = id;
        this.weight = weight;
        this.reps = reps;
    }
}
