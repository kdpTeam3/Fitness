package com.mysite.sbb.workout.routine;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.number.bound.decimal.DecimalMaxValidatorForInteger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
@Transactional
public class RoutineService {
    private final RoutineRepository routineRepository;
//    private final DecimalMaxValidatorForInteger decimalMaxValidatorForInteger;

    public Routine save(Routine routine) {
        return routineRepository.save(routine);
    }

//    public void update(Long Id, RoutineUpdateDto updateParam){
//        Routine findItem = routineRepository.findById(Id).orElseThrow();
//        findItem.setWorkout(updateParam.getWorkout());
//        findItem.setSets(updateParam.getSets());
//        findItem.setReps(updateParam.getReps());
//        findItem.setWeight(updateParam.getWeight());
//    }


}
