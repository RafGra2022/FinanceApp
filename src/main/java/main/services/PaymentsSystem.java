package main.services;

import lombok.RequiredArgsConstructor;
import main.entities.Payments;
import main.model.payment.PaymentDTO;
import main.repositories.PaymentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentsSystem {

    private final PaymentsRepository paymentsRepository;

    public ResponseEntity paymentRecord(PaymentDTO paymentDTO){
        Payments payments= new Payments();
        payments.setUser(paymentDTO.get_user());
        payments.setPaymentType(paymentDTO.get_paymentType());
        payments.setFromDate(paymentDTO.get_from());
        payments.setToDate(paymentDTO.get_to());
        payments.setTerm(paymentDTO.get_term());
        payments.setSum(paymentDTO.get_sum());
        this.paymentsRepository.save(payments);
        return new ResponseEntity(HttpStatus.OK);
    }

}
