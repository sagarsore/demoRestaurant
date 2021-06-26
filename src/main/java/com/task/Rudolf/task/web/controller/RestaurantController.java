package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.entities.Restaurant;
import com.task.Rudolf.task.service.PlantService;
import com.task.Rudolf.task.service.RestaurantService;
import com.task.Rudolf.task.web.data.PlantDto;
import com.task.Rudolf.task.web.data.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/addRestaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
    @PostMapping
    public String addPlant(final RestaurantDto restaurantDto) throws IOException {
        restaurantService.add(restaurantDto);
        return "/viewRestaurants";
    }

    @GetMapping
    public String listAllRestaurants(final Model model)
    {
        List<Restaurant> restaurantList = restaurantService.listAllRestaurants();
 model.addAttribute("restaurants",restaurantList);
 return  "/viewRestaurants";
    }
}