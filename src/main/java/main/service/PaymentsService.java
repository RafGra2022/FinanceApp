package main.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.domain.payment.PaymentDto;
import main.repository.payment.PaymentsRepository;
import main.repository.payment.PaymentEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

    @Transactional
    public void createPayment(PaymentDto paymentDto){
        paymentsRepository.createPayment(paymentDto);
    }

    public List<PaymentEntity> getPayments(){
        List<PaymentEntity> paymentsList = new ArrayList<PaymentEntity>();
        this.paymentsRepository.findByUser("Rafal102").forEach((entity)->{
            if(entity.getPaymentType().equals("electric")){
                paymentsList.add(entity);
            }
        });
        return paymentsList;
    }

}
