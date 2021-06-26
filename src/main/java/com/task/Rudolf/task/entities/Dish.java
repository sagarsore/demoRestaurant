package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
public class Dish extends Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double employeePrice;
    private double guestPrice;
    @ManyToMany
    private Set<Restaurant> restaurants;
}
