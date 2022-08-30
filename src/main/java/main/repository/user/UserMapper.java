package main.repository.user;

import main.domain.user.UserDto;

public class UserMapper {

    private UserMapper(){}

    public static UserEntity mapToUserEntity(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setUser(userDto.getUser());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
