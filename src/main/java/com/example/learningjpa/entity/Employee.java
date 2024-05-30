package com.example.learningjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "mission")
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

    /**
     * NOTE: department_id is the name of the column that will be
     * used as a foreign key in the table employee.
     * department is the name of the field that should be passed to
     * @OneToMany(mappedBy = "department"
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "department_id"
    )
    private Department department;


    /**
     * inverseJoinColumns specifies the column of Mission used as part
     * of the join table relationship.
     *
     * joinColumns will instead will connect to the owner side of the relationship
     */
    @JoinTable(
            name = "employee_mission",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Mission> mission;


}
