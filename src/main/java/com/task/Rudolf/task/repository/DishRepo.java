package com.task.Rudolf.task.repository;

import com.task.Rudolf.task.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepo extends JpaRepository<Dish,Long> {
}
