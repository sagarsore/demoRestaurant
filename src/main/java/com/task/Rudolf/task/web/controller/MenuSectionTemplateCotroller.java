package com.task.Rudolf.task.web.controller;

import com.task.Rudolf.task.service.MenuSectionTemplateService;
import com.task.Rudolf.task.web.data.MenuSectionTemplateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MenuSectionTemplateCotroller {
    @Autowired
    MenuSectionTemplateService menuSectionTemplateService;

    @PostMapping("/addMenuSectionTemplate")
    public String addTemplate(@Valid MenuSectionTemplateDto menuSectionTemplateDto, BindingResult bindingResult, final Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("result",bindingResult.getFieldErrors());
            return "/result";
        }
        menuSectionTemplateService.addTemplate(menuSectionTemplateDto);
        return "/result";
    }
}
