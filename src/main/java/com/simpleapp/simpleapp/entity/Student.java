package com.simpleapp.simpleapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "surname")
    private String surname;
}
