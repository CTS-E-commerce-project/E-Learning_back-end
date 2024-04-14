package com.satwik.e_learningapp.service.serviceImpl;

import com.satwik.e_learningapp.dto.AllUserDto;
import com.satwik.e_learningapp.dto.LoginDto;
import com.satwik.e_learningapp.dto.UserDto;
import com.satwik.e_learningapp.entity.User;
import com.satwik.e_learningapp.mapper.UserMapper;
import com.satwik.e_learningapp.repository.UserRepo;
import com.satwik.e_learningapp.service.EmailService;
import com.satwik.e_learningapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailService emailService;


    @Override
    public UserDto createUser(UserDto userDto) {
        String randomId = UUID.randomUUID().toString();
        userDto.setToken(randomId);
        User user = UserMapper.mapToUser(userDto);
        User saveUser = userRepo.save(user);
        return UserMapper.mapToUserDto(saveUser);
    }

    @Override
    public User userLogin(LoginDto loginDto) {
        User user = userRepo.findById(loginDto.getPhoneNumber()).orElseThrow(() -> new RuntimeException("User does not exist"));
        String currentPassword = user.getPassword();
        if (currentPassword.equals(loginDto.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public List<AllUserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<AllUserDto> allUserDto = users.stream().map((user) -> new AllUserDto(user.getUserName(),
                user.getPhoneNumber())).collect(Collectors.toList());
        return allUserDto;
    }

    @Override
    public User forgotPassword(String email) {
        User user = userRepo.findByUserEmail(email);

        if (user != null) {
            String token = user.getToken();
            emailService.sendVerificationEmail(email, token);
            return user;
        }
        return null;

    }

    @Override
    public User resetPassword(String password, String token) {
        User user = userRepo.findByToken(token);
        user.setPassword(password);
        userRepo.save(user);
        return user;
    }

}