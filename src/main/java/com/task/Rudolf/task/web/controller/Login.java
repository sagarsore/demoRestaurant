package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class Login {
    @Autowired
    private UserService userService;

    @GetMapping
    public String login(@RequestParam String username,@RequestParam String password)
    {
        try{
   userService.verifyUser(username, password);
        }catch(Exception e)
        {
            return "/error";
        }
        return "/home";
    }
}
