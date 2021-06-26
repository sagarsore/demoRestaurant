package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Plant extends PointOfService
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    @OneToMany(
            cascade = CascadeType.ALL,mappedBy = "plant"
    )
    private List<Restaurant> restaurants=new ArrayList();

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }


}
