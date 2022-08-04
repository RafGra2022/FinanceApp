package main.repository.payment;

import main.domain.payment.PaymentDto;

public interface PaymentsCustomRepository {

    void createPayment(PaymentDto paymentDto);
}
