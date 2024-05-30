package com.example.learningjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
/**
 * by exluding course we make it so when we
 * try to get the data from the db, we don't ask for the
 * column course as well. This is done it would return
 * an error if we try to get the table coursematerial without
 * fetching courses first
 */
@ToString(exclude = "course")

public class CourseMaterial {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long courseMaterialId;
    private String url;

    /**
     * Defined the association type btw/ course and courseMaterial
     * using @OneToOne, then I specified the foreign key
     * using the @JoinColumn.
     * This is a oneToone UNIDIRECTINAL mapping because
     * only one class is holding the relationship
     *
     * the cascade parameter says to cascade changes in courseMaterial to Course
     *
     * FetchType.lazy fetches course only when it's specifically asked
     */
    @OneToOne(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}