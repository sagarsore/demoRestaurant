package com.task.Rudolf.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
public class TextMenuItem extends MenuItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
