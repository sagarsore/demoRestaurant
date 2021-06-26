package com.task.Rudolf.task.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter@Setter
public class Restaurant extends PointOfService{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean servesGuest;
    @ManyToOne @JoinColumn(name="plant_id", referencedColumnName = "id")
    private Plant plant;
    @ManyToMany
    private Set<Dish> dishes;
    @OneToMany
    private List<Menu> menus;
    @ManyToMany
    private Set<DishCategory> dishCategories;

}
