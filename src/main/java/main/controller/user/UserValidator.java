package main.controller.user;

import lombok.RequiredArgsConstructor;
import main.repository.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public boolean isUserNotExist(String user) {
        return userRepository.findByUser(user).isEmpty();
    }

    public boolean isLoginCorrect(String user, String password) {
        return userRepository.findByUserAndPassword(user, password).isPresent();
    }
}
