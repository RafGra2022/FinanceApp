package main.domain;

import lombok.RequiredArgsConstructor;
import main.repository.model.User;
import main.domain.UserDTO;
import main.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidation {

    private final UserRepository userRepository;

    public ResponseEntity<UserDTO> registerValidate(UserDTO userDTO) {

        if (userRepository.findByUser(userDTO.getUser()).isEmpty()) {
            this.userRepository.save(new User(userDTO.getUser(), userDTO.getPassword()));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    public ResponseEntity<UserDTO> loginValidate(String user, String password) {

        if (userRepository.findByUser(user).isEmpty()) {
            return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
        } else if (userRepository.findByPassword(password).isEmpty()) {
            return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
        } else if (userRepository.findByUser(user).get(0).getPassword().equals(password)) {
            return new ResponseEntity<UserDTO>(new UserDTO(user, password), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
        }
    }
}
