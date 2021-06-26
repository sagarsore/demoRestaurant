package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
@Entity
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private Media thumbnail;
    @OneToOne(cascade = CascadeType.ALL)
    private Media picture;
    @ManyToMany
    private Set<Category> supercategories;
}
