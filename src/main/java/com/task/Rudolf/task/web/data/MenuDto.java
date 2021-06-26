package com.task.Rudolf.task.web.data;

import com.task.Rudolf.task.entities.MenuSection;
import com.task.Rudolf.task.entities.Restaurant;

import javax.persistence.ManyToOne;
import java.util.List;

public class MenuDto {
    private List<Integer> sections;
    private int restaurant;
}
