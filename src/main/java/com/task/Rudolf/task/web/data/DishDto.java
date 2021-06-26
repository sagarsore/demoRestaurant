package com.task.Rudolf.task.web.data;

import com.task.Rudolf.task.entities.Restaurant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.util.Set;

@Getter@Setter
public class DishDto {
    private double employeePrice;
    private double guestPrice;
    private Set<Integer> restaurants;
}
