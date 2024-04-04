package com.satwik.e_learningapp.service;

import com.satwik.e_learningapp.dto.AllUserDto;
import com.satwik.e_learningapp.dto.LoginDto;
import com.satwik.e_learningapp.dto.UserDto;
import com.satwik.e_learningapp.entity.User;
import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public User userLogin(LoginDto loginDto);
    public List<AllUserDto> getAllUsers();

}
