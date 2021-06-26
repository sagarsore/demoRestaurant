package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.entities.Media;
import com.task.Rudolf.task.entities.Menu;
import com.task.Rudolf.task.entities.MenuSectionTemplate;
import com.task.Rudolf.task.repository.MenuSectionTemplateRepo;
import com.task.Rudolf.task.service.MenuSectionTemplateService;
import com.task.Rudolf.task.web.data.MenuSectionTemplateDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuSectionTemplateServiceImpl implements MenuSectionTemplateService {
    @Autowired
    MenuSectionTemplateRepo menuSectionTemplateRepo;
    @Override
    public void addTemplate(MenuSectionTemplateDto menuSectionTemplateDto) {
        MenuSectionTemplate menuSectionTemplate = new MenuSectionTemplate();
        BeanUtils.copyProperties(menuSectionTemplateDto,menuSectionTemplate);
        Media thumbnail = new Media();
        thumbnail.setPhoto(menuSectionTemplateDto.getThumbnail().getOriginalFilename());
        Media picture = new Media();
        thumbnail.setPhoto(menuSectionTemplateDto.getPicture().getOriginalFilename());
        menuSectionTemplate.setThumbnail(thumbnail);
        menuSectionTemplate.setPicture(picture);
        menuSectionTemplateRepo.save(menuSectionTemplate);
    }

    @Override
    public List<MenuSectionTemplate> viewTemplates() {
        return menuSectionTemplateRepo.findAll();
    }
}
