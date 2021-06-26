package com.task.Rudolf.task.service;

import com.task.Rudolf.task.entities.MenuItem;
import com.task.Rudolf.task.web.data.MenuItemDto;

import java.util.List;


public interface MenuItemService {

     void addMenuItem(MenuItemDto menuItemDto);
     List<MenuItem> viewMenuItems();
}
