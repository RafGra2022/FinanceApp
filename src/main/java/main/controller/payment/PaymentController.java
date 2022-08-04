package main.controller.payment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import main.repository.payment.PaymentMapper;
import main.domain.payment.PaymentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static main.controller.payment.PaymentMapper.toPaymentDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentsService paymentsService;

    @PostMapping("/payments")
    public ResponseEntity paymentRecord(@RequestBody PaymentRequest paymentRequest) {
        paymentsService.createPayment(toPaymentDTO(paymentRequest));
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/userPayments")
    public String showUserPayments() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String json = mapper.writeValueAsString(this.paymentsService.findUserPayments());
        return json;
    }
}
