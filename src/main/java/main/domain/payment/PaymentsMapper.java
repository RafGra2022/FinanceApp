package main.domain.payment;

import lombok.RequiredArgsConstructor;
import main.repository.payment.PaymentEntity;
import main.repository.payment.PaymentsRepository;
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
