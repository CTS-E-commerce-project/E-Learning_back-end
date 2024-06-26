package com.satwik.e_learningapp.controller;

import com.satwik.e_learningapp.dto.AllUserDto;
import com.satwik.e_learningapp.dto.LoginDto;
import com.satwik.e_learningapp.dto.UserDto;
import com.satwik.e_learningapp.entity.User;
import com.satwik.e_learningapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/eLearning/v1")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @PostMapping("/Login")
    public ResponseEntity<User> userLogin(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(userService.userLogin(loginDto),HttpStatus.OK);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<AllUserDto>> getAllUsers(){
        List<AllUserDto> allUser = userService.getAllUsers();
        return ResponseEntity.ok(allUser);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<User> forgotPassword(@RequestBody Map<String,String> requestBody){
        return ResponseEntity.ok(userService.forgotPassword(requestBody.get("email")));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<User> resetPassword(@RequestBody Map<String,String> requestBody){
        return ResponseEntity.ok(userService.resetPassword(requestBody.get("password"),requestBody.get("token")));
    }
}
