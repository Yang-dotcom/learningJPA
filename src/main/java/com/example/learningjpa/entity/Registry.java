package com.example.learningjpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

public class Registry {
    private String registryName;
    private String registryFirstName;
    private Integer age;
    private String gender;
    private Date date_birth;
}
