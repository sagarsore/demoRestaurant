package com.task.Rudolf.task.service.Impl;

import com.task.Rudolf.task.Exception.CommonException;
import com.task.Rudolf.task.entities.Media;
import com.task.Rudolf.task.entities.Product;
import com.task.Rudolf.task.repository.CategoryRepo;
import com.task.Rudolf.task.repository.ProductRepo;
import com.task.Rudolf.task.service.ProductService;
import com.task.Rudolf.task.web.data.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Value("${file.upload-dir}")
    private String uploadPath;
    @Override
    @Transactional
    public void addProduct(ProductDto productDto) throws CommonException,Exception {
        Product product = new Product();
        Media thumbnail = null;
        BeanUtils.copyProperties(productDto,product);
        MultipartFile pictureFile = productDto.getPicture();
        MultipartFile thumbnailFile = productDto.getThumbnail();
          Files.copy(pictureFile.getInputStream(), Paths.get(uploadPath + pictureFile.getOriginalFilename()));


            Media picture = new Media();
        picture.setPhoto(Paths.get(uploadPath+pictureFile.getOriginalFilename()).toString());
        product.setPicture(picture);

           thumbnail = Media.class.getConstructor().newInstance();

            Files.copy(thumbnailFile.getInputStream(), Paths.get(uploadPath + thumbnailFile.getOriginalFilename()));

        thumbnail.setPhoto(Paths.get(uploadPath+thumbnailFile.getOriginalFilename()).toString());
        product.setThumbnail(thumbnail);
        product.setSupercategories(categoryRepo.findByCategoryIds(productDto.getSupercategories()));
        productRepo.save(product);
    }
}
