package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.service.DishService;
import com.task.Rudolf.task.web.data.DishDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DishController {
    @Autowired
    DishService dishService;
    @PostMapping("/addDish")
    public String addDish(final DishDto dishDto, final Model model)
    {
        dishService.addDish(dishDto);
        model.addAttribute("result","dish added");
        return "/result";
    }

    @GetMapping("/alldishes")
public String allDishes(final Model model)
    {
        model.addAttribute("result",dishService.allDishes());
        return "/result";
    }

}
