package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.entities.Dish;
import com.task.Rudolf.task.entities.Menu;
import com.task.Rudolf.task.entities.WeekDayMenu;
import com.task.Rudolf.task.repository.DishRepo;
import com.task.Rudolf.task.service.DishService;
import com.task.Rudolf.task.web.data.DishDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    DishRepo dishRepo;
    @Override
    public void addDish(DishDto dishDto) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDto,dish);
        dishRepo.save(dish);
    }

    @Override
    public List<Dish> allDishes() {

        return dishRepo.findAll();
    }
}


