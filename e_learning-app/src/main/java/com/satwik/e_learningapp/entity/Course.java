package com.satwik.e_learningapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Course {
    @Id
    private String id;
    private String title;
    @Column (length = 5000)
    private String description;
    private String image;
    private String alt;
    private String courseType;
    private double amount;
}
