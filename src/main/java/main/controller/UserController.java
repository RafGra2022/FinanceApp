package main.controller;

import lombok.RequiredArgsConstructor;
import main.controller.payment.PaymentRequest;
import main.domain.user.UserDTO;
import main.domain.payment.PaymentsMapper;
import main.domain.user.UserValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserValidation userValidation;
    private final PaymentsMapper paymentsSystem;
//    private final PaymentsService paymentsService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        return userValidation.registerValidate(userDTO);
    }

    @PostMapping("/payments")
    public ResponseEntity paymentRecord(@RequestBody PaymentRequest paymentRequest) {
        System.out.println(paymentRequest);
//        paymentsSystem.paymentRecord(PaymentMapper.toPaymentDTO(paymentRequest));
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    public ResponseEntity login(@RequestParam String user, String password) {
        return userValidation.loginValidate(user, password);
    }
    @GetMapping(value = "/run")
    public void test(){
        System.out.println(LocalDate.now().minusDays(100));

    }
    @GetMapping(value = "/test")
    public String check(){
        return "hello";
    }
}
