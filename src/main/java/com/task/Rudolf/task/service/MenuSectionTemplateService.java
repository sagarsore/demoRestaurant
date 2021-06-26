package com.task.Rudolf.task.service;

import com.task.Rudolf.task.entities.MenuSectionTemplate;
import com.task.Rudolf.task.web.data.MenuSectionTemplateDto;

import java.util.List;

public interface MenuSectionTemplateService {
void addTemplate(MenuSectionTemplateDto menuSectionTemplateDto);
List<MenuSectionTemplate> viewTemplates();
}
