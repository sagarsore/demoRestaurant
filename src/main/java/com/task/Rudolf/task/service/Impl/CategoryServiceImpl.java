package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.entities.Category;
import com.task.Rudolf.task.entities.Media;
import com.task.Rudolf.task.repository.CategoryRepo;
import com.task.Rudolf.task.repository.ProductRepo;
import com.task.Rudolf.task.service.CategoryService;
import com.task.Rudolf.task.web.data.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
@Autowired
    ProductRepo productRepo;
    @Value("${file.upload-dir}")
    private String uploadPath;
    @Override
    public void addCategory(CategoryDto categoryDto) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Category category = new Category();
        MultipartFile pictureFile = categoryDto.getPicture();
        MultipartFile thumbnailFile = categoryDto.getThumbnail();
        Files.copy(pictureFile.getInputStream(), Paths.get(uploadPath + pictureFile.getOriginalFilename()));


        Media picture = new Media();
        picture.setPhoto(Paths.get(uploadPath+pictureFile.getOriginalFilename()).toString());
        category.setPicture(picture);

        Media thumbnail = Media.class.getConstructor().newInstance();

        Files.copy(thumbnailFile.getInputStream(), Paths.get(uploadPath + thumbnailFile.getOriginalFilename()));

        thumbnail.setPhoto(Paths.get(uploadPath+thumbnailFile.getOriginalFilename()).toString());
        category.setThumbnail(thumbnail);
        category.setProducts(productRepo.findByProductIds(categoryDto.getProducts()));
    }
}
