package main.domain;

import lombok.RequiredArgsConstructor;
import main.repository.model.PaymentEntity;
import main.repository.PaymentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentsMapper {

    private final PaymentsRepository paymentsRepository;

    public void paymentRecord(PaymentDTO paymentDTO) {
        PaymentEntity payments = new PaymentEntity();
        payments.setUser(paymentDTO.getUser());
        payments.setPaymentType(paymentDTO.getPaymentType());
        payments.setFromDate(paymentDTO.getFrom());
        payments.setToDate(paymentDTO.getTo());
        payments.setTerm(paymentDTO.getTerm());
        payments.setSum(paymentDTO.getSum());
        this.paymentsRepository.save(payments);
    }



}
