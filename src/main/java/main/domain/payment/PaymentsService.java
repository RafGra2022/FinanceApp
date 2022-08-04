package main.domain.payment;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
//    private final Visits visits;

//    private List<PaymentEntity> nearestExpire(int plusDays) {
//        return this.paymentsRepository.findByToDate(LocalDate.now().plusDays(plusDays));
//    }

//    private List<PaymentEntity> Expired() {
//        return this.paymentsRepository.findByToDate(visits.getLastVisit());
//    }
//
//    private void addNextPayment(PaymentEntity paymentEntity) {
//        PaymentEntity nextPaymentEntity = new PaymentEntity();
//        nextPaymentEntity.setPaymentType(paymentEntity.getPaymentType());
//        nextPaymentEntity.setFromDate(paymentEntity.getToDate());
//        nextPaymentEntity.setSum(paymentEntity.getSum());
//        nextPaymentEntity.setTerm(paymentEntity.getToDate().plusMonths(2).plusDays(14));
//        nextPaymentEntity.setToDate(paymentEntity.getToDate().plusMonths(2));
//        nextPaymentEntity.setUser(paymentEntity.getUser());
//        this.paymentsRepository.save(nextPaymentEntity);
//    }

    @Transactional
    public void createPayment(PaymentDto paymentDto){
        paymentsRepository.createPayment(paymentDto);
    }

    public List<PaymentEntity> findUserPayments(){
        List<PaymentEntity> entityList = new ArrayList<PaymentEntity>();
        this.paymentsRepository.findByUser("Rafal102").forEach((entity)->{
            if(entity.getPaymentType().equals("electric")){
                entityList.add(entity);
            }
        });
        return entityList;
    }

//    public void update() {
//        LocalDate latest = visits.getLastVisit();
//        while (!latest.equals(LocalDate.now())) {
//            for (PaymentEntity paymentEntity : Expired()) {
//                this.addNextPayment(paymentEntity);
//            }
//            latest = latest.plusDays(1);
//        }
//        for (int plusDays = 0; plusDays < 14; plusDays++) {
//            for (PaymentEntity paymentEntity : nearestExpire(plusDays)) {
//                this.addNextPayment(paymentEntity);
//            }
//        }
//    }

}
