package com.satwik.e_learningapp.mapper;
import com.satwik.e_learningapp.dto.UserDto;
import com.satwik.e_learningapp.entity.User;

public class UserMapper {
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getPhoneNumber(),
                userDto.getUserName(),
                userDto.getUserEmail(),
                userDto.getPassword(),
                "user"
        );
        return user;
    }

    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getPhoneNumber(),
                user.getUserName(),
                user.getUserEmail(),
                user.getPassword()
        );
        return userDto;
    }


}
