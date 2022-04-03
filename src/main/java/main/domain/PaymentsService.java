package main.domain;

import lombok.AllArgsConstructor;
import main.repository.PaymentsRepository;
import main.repository.model.PaymentEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;

//    public List<PaymentEntity> userData(String user) {
//        return this.paymentsRepository.findByUser(user);
//    }

    private List<PaymentEntity> nearestExpire(int plusDays) {
        ArrayList<PaymentEntity> date = new ArrayList<PaymentEntity>();
        return this.paymentsRepository.findByToDate(LocalDate.now().plusDays(plusDays));
    }

    private void addNextPayment(PaymentEntity paymentEntity) {
        PaymentEntity nextPaymentEntity = new PaymentEntity();
        nextPaymentEntity.setPaymentType(paymentEntity.getPaymentType());
        nextPaymentEntity.setFromDate(paymentEntity.getToDate());
        nextPaymentEntity.setSum(paymentEntity.getSum());
        nextPaymentEntity.setTerm(paymentEntity.getToDate().plusMonths(2).plusDays(14));
        nextPaymentEntity.setToDate(paymentEntity.getToDate().plusMonths(2));
        nextPaymentEntity.setUser(paymentEntity.getUser());
        this.paymentsRepository.save(nextPaymentEntity);
    }

    public void updateExpired() {
        for (int plusDays = 0; plusDays < 14; plusDays++) {
            for (PaymentEntity paymentEntity : nearestExpire(plusDays)) {
                this.addNextPayment(paymentEntity);
            }
        }
    }

//    public LocalDate sortLatest(String user) {
//        LocalDate dateLatest = LocalDate.of(2020, 1, 8);
//        ArrayList<LocalDate> tillDate = new ArrayList<LocalDate>();
//        for (PaymentEntity paymentEntity : this.userData(user)) {
//            tillDate.add(paymentEntity.getToDate());
//        }
//        for (LocalDate dateTemporary : tillDate) {
//            if (dateTemporary.isAfter(ChronoLocalDate.from(dateLatest))) {
//                dateLatest = dateTemporary;
//            }
//        }
//        return dateLatest;
//    }

}
