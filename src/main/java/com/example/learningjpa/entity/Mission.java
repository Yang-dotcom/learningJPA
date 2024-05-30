package com.example.learningjpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int duration;

    /**
     * Using MappedBy parameter we declare that
     * the owner of the relationship is not this one
     */
    @ManyToMany(mappedBy = "mission")
    private List<Employee> employees;

}
