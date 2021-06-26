package com.task.Rudolf.task.service;

import com.task.Rudolf.task.entities.OpeningDay;
import com.task.Rudolf.task.web.data.OpeningDayDto;

import java.util.Optional;

public interface OpeningDayService {
    void addOpeningDay(OpeningDayDto openingDayDto);
    Optional<OpeningDay> findById(long id);

}
