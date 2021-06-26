package com.task.Rudolf.task.web.data;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
@Data
public class MenuSectionTemplateDto {
    private int menuRank;
    private String name;
    private Date startTime;
    private Date endTime;
    @NotEmpty
    private List<Integer> restaurants;
    private MultipartFile thumbnail;
    private MultipartFile picture;
}
