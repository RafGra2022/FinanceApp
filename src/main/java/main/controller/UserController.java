package main.controller;

import lombok.RequiredArgsConstructor;
import main.model.login.UserDTO;
import main.repositories.UserRepository;
import main.services.UserValidation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserValidation userValidation;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        return userValidation.registerValidate(userDTO);
    }

    @GetMapping(value = "/login")
    public ResponseEntity login(@RequestHeader HttpHeaders headers, @RequestParam String user, String password) {

        return userValidation.loginValidate(user, password);
    }

    @RequestMapping("/hello")
    public String test() {
        return "hello";
    }
}
