package com.task.Rudolf.task.web.controller;


import com.task.Rudolf.task.Exception.CommonException;
import com.task.Rudolf.task.service.CategoryService;
import com.task.Rudolf.task.web.data.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping("/addCategory")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping
    @ExceptionHandler(CommonException.class)
    public  String addCategory(final CategoryDto categoryDto, final Model model) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        categoryService.addCategory(categoryDto);
      return "/result" ;
    }
}
