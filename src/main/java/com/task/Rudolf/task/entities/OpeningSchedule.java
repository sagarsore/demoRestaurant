package com.task.Rudolf.task.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@Entity
public class OpeningSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@OneToMany(cascade = CascadeType.DETACH)
    private List<OpeningDay> openingDayS;

}
