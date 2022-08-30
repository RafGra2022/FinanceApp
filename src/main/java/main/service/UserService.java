package main.service;

import lombok.RequiredArgsConstructor;
import main.controller.user.UserValidator;
import main.domain.user.UserDto;
import main.repository.user.UserEntity;
import main.repository.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static main.repository.user.UserMapper.mapToUserEntity;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserValidator userValidation;
    private final UserRepository userRepository;

    public ResponseEntity<UserDto> addUser(UserDto userDto) {

        if (userValidation.isUserNotExist(userDto.getUser())) {
            this.userRepository.save(mapToUserEntity(userDto));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<UserDto> validateUser(String user, String password) {

        if (userValidation.isLoginCorrect(user, password)) {
            return new ResponseEntity<UserDto>(new UserDto(user, password), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserDto>(HttpStatus.BAD_REQUEST);
        }
    }

}
