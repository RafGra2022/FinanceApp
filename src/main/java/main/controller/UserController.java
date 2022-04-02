package main.controller;

import lombok.RequiredArgsConstructor;
import main.domain.UserDTO;
import main.domain.PaymentDTO;
import main.domain.PaymentsService;
import main.domain.UserValidation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserValidation userValidation;
    private final PaymentsService paymentsSystem;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        return userValidation.registerValidate(userDTO);
    }

    @PostMapping("/payments")
    public ResponseEntity paymentRecord(@RequestBody PaymentDTO paymentDTO) {
        return paymentsSystem.paymentRecord(paymentDTO);
    }

    @GetMapping(value = "/login")
    public ResponseEntity login(@RequestHeader HttpHeaders headers, @RequestParam String user, String password) {
        return userValidation.loginValidate(user, password);
    }
}
