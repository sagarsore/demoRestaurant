package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.service.WeekDayMenuService;
import com.task.Rudolf.task.web.data.WeekDayMenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeekDayMenuController {
    @Autowired
    WeekDayMenuService weekDayMenuService;
    @PostMapping("/addWeekDayMenu")
    public String addWeekDayMenu(WeekDayMenuDto weekDayMenuDto, final Model model)
    {
        weekDayMenuService.addWeekDayMenu(weekDayMenuDto);
        model.addAttribute("result","Week day menu added");
        return "/result";
    }
    @GetMapping("/viewWeekDayMenus")
    public String viewWeekDayMenus( final Model model)
    {
        model.addAttribute("result",weekDayMenuService.listWeekDayMenus().toString());
        return "/result";
    }

}
