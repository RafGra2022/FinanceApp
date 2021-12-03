package main.controller;


import main.model.register.UserData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
public class Service {

//    @Autowired
//    private UsersBase usersBase;
//    @Autowired
//    private UserData userData;

    @PostMapping("/register")
    private ResponseEntity key(@RequestBody UserData users) throws SQLException {
        System.out.println(users.get_ID());
//        User user = new User(users.get_ID(), users.get_password());
        //usersBase.createUser();
//        usersBase.insertUser(users);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    public void getUser(@RequestHeader HttpHeaders headers, @RequestParam String user , String password) throws SQLException {

        String userData = user;
        String passwordData = password;


    }

    @RequestMapping("/hello")
    public String test(){
        return "somet";
    }

}
