package com.example.learningjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long courseId;
    private String title;
    private Integer credit;

    /**
     * This declaration changes the unidirectional link
     * btw/ course and courseMaterial into a bidirectional link
     *
     */
    @OneToOne(mappedBy = "course")
    @JoinColumn(
            name = "courseMaterial_id",
            referencedColumnName = "courseMaterialId"
    )
    private CourseMaterial courseMaterial;
}
