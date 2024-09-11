package com.mysite.sbb.workout.routine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoutineUpdateDto {
    private String routinename;
    private String username;
    private String workout;
    private Integer sets;
    private Integer reps;
    private Integer weight;

    public RoutineUpdateDto(){
    }

    public RoutineUpdateDto(String routinename, String username,String workout, Integer sets, Integer reps, Integer weight) {
        this.routinename = routinename;
        this.username = username;
        this.workout = workout;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }
}
