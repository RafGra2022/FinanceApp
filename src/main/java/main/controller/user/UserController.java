package main.controller.user;

import lombok.RequiredArgsConstructor;
import main.domain.user.UserDTO;
import main.domain.user.UserValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserValidation userValidation;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        return userValidation.registerValidate(userDTO);
    }

    @GetMapping(value = "/login")
    public ResponseEntity login(@RequestParam String user, String password) {
        return userValidation.loginValidate(user, password);
    }
//    @GetMapping(value = "/run")
//    public void test(){
//        System.out.println(LocalDate.now().minusDays(100));
//
//    }
    @GetMapping(value = "/test")
    public String check(){
        return "hello";
    }
}
