package com.example.learningjpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Department {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;

    /**
     * In a 1,N relationship, department partcipates as 1
     * employees as many. I.e. One department can be participated
     * by several employees, but several employees can participate
     * in one department
     */
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
