package com.mysite.sbb.workout.record;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RecordService {

    private final RecordRepository recordRepository;

    public Record save(Record record) {
        return recordRepository.save(record);
    }
}
