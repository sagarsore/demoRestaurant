package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.entities.MenuItem;
import com.task.Rudolf.task.service.MenuItemService;
import com.task.Rudolf.task.web.data.MenuItemDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuItemController {
    @Autowired
    MenuItemService menuItemService;
    @PostMapping("/addMenuItem")
    public  String addMenuItem(final MenuItemDto menuItemDto, BindingResult bindingResult, final Model model)
    {
     if(bindingResult.hasErrors())
     {
         model.addAttribute("result",bindingResult.getFieldErrors());
         return "/result";
     }
     menuItemService.addMenuItem(menuItemDto);
     return "/result";
    }

    @GetMapping("/viewMenuItems")
    public String viewMenuItems(final Model model)
    {
      model.addAttribute(menuItemService.viewMenuItems());
      return "/result";
    }
}
