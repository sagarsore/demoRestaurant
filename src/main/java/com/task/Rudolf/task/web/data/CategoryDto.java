package com.task.Rudolf.task.web.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
@Getter@Setter
public class CategoryDto {
    private MultipartFile thumbnail;
    private MultipartFile picture;
    private Set<Long> products;
}
