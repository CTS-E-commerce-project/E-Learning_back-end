package com.satwik.e_learningapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class AllUserDto {
    private String userName;
    private String userEmail;
    private String phoneNumber;
}
