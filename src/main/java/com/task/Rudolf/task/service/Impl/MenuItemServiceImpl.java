package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.entities.Media;
import com.task.Rudolf.task.entities.MenuItem;
import com.task.Rudolf.task.repository.MenuItemRepo;
import com.task.Rudolf.task.service.MenuItemService;
import com.task.Rudolf.task.web.data.MenuItemDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuItemServiceImpl implements MenuItemService {
    @Autowired
    MenuItemRepo menuItemRepo;
    @Override
    public void addMenuItem(MenuItemDto menuItemDto) {
        MenuItem menuItem = new MenuItem();
        BeanUtils.copyProperties(menuItemDto,menuItem);
        Media thumbnail = new Media();
        thumbnail.setPhoto(menuItemDto.getThumbnail().getOriginalFilename());
        menuItem.setThumbnail(thumbnail);
        menuItemRepo.save(menuItem);

    }

    @Override
    public List<MenuItem> viewMenuItems() {
       return menuItemRepo.findAll();
    }
}
