package com.example.learningjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees",
        uniqueConstraints = @UniqueConstraint(
                name = "firstName_unique",
                columnNames = "firstName"))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "firstName")
//    private String firstName;
//    @Column(name = "age")
//    private Integer age;
//    @Column(name = "gender")
//    private String gender;
//    @Column(name = "date_birth")
//    private Date date_birth;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name="registryName",
                    column = @Column(name="name")
            ),
            @AttributeOverride(
                    name="registryFirstName",
                    column = @Column(name="first_name")
            ),
            @AttributeOverride(
                    name="age",
                    column = @Column(name="age")
            ),
            @AttributeOverride(
                    name="gender",
                    column = @Column(name="gender")
            ),
            @AttributeOverride(
                    name="date_birth",
                    column = @Column(name="date_birth")
            )
    })
    private Registry registry;
    @Column(name = "job", nullable = false)
    private String job;
}
