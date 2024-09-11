package com.mysite.sbb.workout.record;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecordUpdateDto {
    private String workoutdate;
    private String routine;
    private String username;

    public RecordUpdateDto() {

    }

    public RecordUpdateDto(String workoutdate, String routine, String username) {
        this.workoutdate = workoutdate;
        this.routine = routine;
        this.username = username;
    }

}
