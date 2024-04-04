package com.satwik.e_learningapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class LoginDto {
    private String phoneNumber;
    private String password;
}
