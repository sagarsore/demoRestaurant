package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class DishCategoryMenuItem extends MenuItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@OneToOne
@NotNull
    private DishCategory dishCategory;
}
