package main.controller.user;

import lombok.RequiredArgsConstructor;
import main.domain.user.UserDto;
import main.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping(value = "/login")
    public ResponseEntity login(@RequestParam String user, String password) {
        return userService.validateUser(user, password);
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
