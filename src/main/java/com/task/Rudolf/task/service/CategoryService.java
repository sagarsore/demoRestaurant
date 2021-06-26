package com.task.Rudolf.task.service;


import com.task.Rudolf.task.web.data.CategoryDto;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface CategoryService {
    public void addCategory(CategoryDto categoryDto) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
