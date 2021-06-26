package com.task.Rudolf.task.web.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Setter
@Getter
public class ProductDto {
    @NotEmpty
    private String code;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    private MultipartFile thumbnail;
    private MultipartFile picture;
    private Set<Long> supercategories;
}
