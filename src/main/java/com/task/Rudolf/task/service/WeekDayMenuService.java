package com.task.Rudolf.task.service;

import com.task.Rudolf.task.entities.WeekDayMenu;
import com.task.Rudolf.task.web.data.WeekDayMenuDto;

import java.util.List;

public interface WeekDayMenuService {
   void addWeekDayMenu(WeekDayMenuDto weekDayMenuDto);
    public List<WeekDayMenu> listWeekDayMenus();
}
