package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter@Setter
@MappedSuperclass
public class PointOfService {

private String name;
private Address address;
private String description;
@OneToOne(cascade = CascadeType.ALL )
private OpeningSchedule openingSchedule;
@OneToMany(cascade = CascadeType.ALL)
private List<Media> media = new ArrayList();

}
