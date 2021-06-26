package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.entities.OpeningDay;
import com.task.Rudolf.task.repository.OpeningDayRepo;
import com.task.Rudolf.task.service.OpeningDayService;
import com.task.Rudolf.task.web.data.OpeningDayDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OpeningDayServiceImpl implements OpeningDayService {

    @Autowired
    OpeningDayRepo openingDayRepo;

    @Override
    public void addOpeningDay(OpeningDayDto openingDayDto) {
        OpeningDay openingDay = new OpeningDay();
        BeanUtils.copyProperties(openingDayDto,openingDay);
        openingDayRepo.save(openingDay);
    }

    @Override
    public Optional<OpeningDay> findById(long id) {
      return openingDayRepo.findById(id);
    }
}
