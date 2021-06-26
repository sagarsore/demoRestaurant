package com.task.Rudolf.task.service;

import com.task.Rudolf.task.entities.Plant;
import com.task.Rudolf.task.web.data.PlantDto;

import java.io.IOException;

public interface PlantService {

     void addPlant(final PlantDto plant) throws IOException;
     Plant getPlantById(long id);
}
