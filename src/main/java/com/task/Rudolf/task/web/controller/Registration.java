package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.service.UserService;
import com.task.Rudolf.task.web.data.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class Registration {


    @Autowired
    private UserService userService;


    @PostMapping
    public String userRegistration(final UserData userData, final BindingResult bindingResult, final Model model) {
        System.out.println("cotroller");
        if (bindingResult.hasErrors()) {
            model.addAttribute("registrationForm", userData);
            return "account/register";
        }
        try {
            userService.register(userData);
        } catch (Exception e) {
            bindingResult.rejectValue("email", "userData.email", "An account already exists for this email.");
            model.addAttribute("registrationForm", userData);
            return "/registerSu";
        }
        model.addAttribute("registrationMsg", "test");
        return "account/register";
    }

}