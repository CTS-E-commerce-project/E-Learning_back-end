package com.satwik.e_learningapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String phoneNumber;
    private String userName;
    private String userEmail;
    private String password;
    private String role;
    private String token;
}
