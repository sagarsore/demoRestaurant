package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class MenuSectionTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int menuRank;
    private String name;
    private Date startTime;
    private Date endTime;
    @OneToMany@NotNull
    private List<Restaurant> restaurants;
    @OneToOne
    private Media thumbnail;
    @OneToOne
    private Media picture;
}
