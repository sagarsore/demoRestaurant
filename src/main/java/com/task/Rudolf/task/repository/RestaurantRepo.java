package com.task.Rudolf.task.repository;


import com.task.Rudolf.task.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long > {
}
