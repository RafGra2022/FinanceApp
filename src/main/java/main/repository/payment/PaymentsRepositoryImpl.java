package main.repository.payment;

import main.domain.payment.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static main.repository.payment.PaymentMapper.mapToPaymentEntity;


public class PaymentsRepositoryImpl implements PaymentsCustomRepository {

    private PaymentsRepository paymentsRepository;


    @Override
    @Transactional
    public void createPayment(PaymentDto paymentDto) {
        this.paymentsRepository.save(mapToPaymentEntity(paymentDto));
    }

    @Autowired
    public void setPaymentsRepository(final PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }
}
