package com.task.Rudolf.task.service;

import com.task.Rudolf.task.entities.Dish;
import com.task.Rudolf.task.web.data.DishDto;

import java.util.List;

public interface DishService {
void addDish(DishDto dish);
List<Dish> allDishes();
}
