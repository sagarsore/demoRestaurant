package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class MenuSection {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="menu_id", referencedColumnName = "id")
    private Menu menu;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "section")
    private List<MenuItem> items;
    @OneToOne
    private MenuSectionTemplate template;

}
