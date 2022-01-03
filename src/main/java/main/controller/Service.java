package main.controller;


import main.entities.User;
import main.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
public class Service {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    private ResponseEntity key(@RequestBody User  user) {

        userRepository.save(user);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    private List getUser(@RequestHeader HttpHeaders headers, @RequestParam String user, String password){

        String userData = user;
        String passwordData = password;
        return userRepository.findByUser(userData);


    }

    @RequestMapping("/hello")
    public String test() {
        return "somet";
    }

}
