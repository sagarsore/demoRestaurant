package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.entities.WeekDayMenu;
import com.task.Rudolf.task.repository.WeekDayMenuRepo;
import com.task.Rudolf.task.service.WeekDayMenuService;
import com.task.Rudolf.task.web.data.WeekDayMenuDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekDayMenuServiceImpl implements WeekDayMenuService {
    @Autowired
    WeekDayMenuRepo weekDayMenuRepo;
    @Override
    public void addWeekDayMenu(WeekDayMenuDto weekDayMenuDto) {
        WeekDayMenu weekDayMenu = new WeekDayMenu();
        BeanUtils.copyProperties(weekDayMenu,weekDayMenuDto);
        weekDayMenuRepo.save(weekDayMenu);
    }

    public List<WeekDayMenu> listWeekDayMenus()
    {
     return weekDayMenuRepo.findAll();
    }
}
