package com.task.Rudolf.task.web.data;

import lombok.Data;

import java.util.List;

@Data
public class WeekDayMenuDto {
     private String weekday;
    private int week;
    private int year;
    private List<Long> sections;
    private long restaurant;
}
