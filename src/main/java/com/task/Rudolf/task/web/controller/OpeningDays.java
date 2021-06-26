package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.entities.OpeningDay;
import com.task.Rudolf.task.repository.OpeningDayRepo;
import com.task.Rudolf.task.web.data.OpeningDayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/addOpeningDays")
public class OpeningDays {
    @Autowired
    OpeningDayRepo openingDayRepo;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
    @PostMapping
    public String addOpeningDays(final OpeningDayDto openingDayDto,final Model model)
    {
         OpeningDay openingDay = new OpeningDay();
         openingDay.setOpeningTime(LocalDateTime.parse(openingDayDto.getOpeningTime(),dateTimeFormatter));
         openingDay.setClosingTime(LocalDateTime.parse(openingDayDto.getClosingTime(),dateTimeFormatter));
        openingDayRepo.save(openingDay);
         model.addAttribute("result","opening day added successfully");
         return "/result";
    }
}
