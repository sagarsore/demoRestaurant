package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne@JoinColumn(name="section_id", referencedColumnName = "id")
    private MenuSection section;

    private String title;
    private String description;
    @OneToOne
    private Media thumbnail;
    private String price;

}
