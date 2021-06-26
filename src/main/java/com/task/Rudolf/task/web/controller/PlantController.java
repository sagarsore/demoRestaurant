package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.service.PlantService;
import com.task.Rudolf.task.web.data.PlantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
    @RequestMapping("/addPlant")
public class PlantController {

    @Autowired
    PlantService plantService;
    @PostMapping
public String addPlant(final PlantDto plantDto, Model model)  {
        try {
            plantService.addPlant(plantDto);
        }catch (IOException e)
        {
            model.addAttribute("result",e.getMessage());
            return "/viewPlants";
        }
        model.addAttribute("result","Plant added");
       return "/viewPlants";
    }
}
