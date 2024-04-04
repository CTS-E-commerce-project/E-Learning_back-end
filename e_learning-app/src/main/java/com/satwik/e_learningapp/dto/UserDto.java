package com.satwik.e_learningapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String phoneNumber;
    private String userName;
    private String userEmail;
    private String password;
}
