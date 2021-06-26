package com.task.Rudolf.task.web.data;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MenuItemDto {
    private int section;
    private String title;
    private String description;
    private MultipartFile thumbnail;
    private String price;

}
