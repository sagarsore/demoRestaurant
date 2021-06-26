package com.task.Rudolf.task.repository;

import com.task.Rudolf.task.entities.Plant;
import com.task.Rudolf.task.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepo extends JpaRepository<Plant, Long > {
}
