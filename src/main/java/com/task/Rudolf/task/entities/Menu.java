package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
//@MappedSuperclass
@Entity
@Getter
@Setter
 public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "menu")
    private List<MenuSection> sections;
    @ManyToOne
   private Restaurant restaurant;
}
