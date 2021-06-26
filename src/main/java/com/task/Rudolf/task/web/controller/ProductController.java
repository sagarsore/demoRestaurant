package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.Exception.CommonException;
import com.task.Rudolf.task.repository.ProductRepo;
import com.task.Rudolf.task.service.ProductService;
import com.task.Rudolf.task.web.data.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/addProduct")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping
    @ExceptionHandler(CommonException.class)
    public String addProduct( @Valid final ProductDto productDto, BindingResult result,final Model model) throws Exception {
        if(result.hasErrors())
        {
            model.addAttribute("result",result.getFieldErrors());
            return "/result";
        }

        productService.addProduct(productDto);
     model.addAttribute("result","Product added successfully");
      return "/result";
    }
}
