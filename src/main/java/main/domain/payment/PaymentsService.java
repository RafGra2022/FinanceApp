package main.domain.payment;

import lombok.AllArgsConstructor;
import main.domain.visit.Visits;
import main.repository.payment.PaymentsRepository;
import main.repository.payment.PaymentEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class PaymentsService {

    private final PaymentsRepository paymentsRepository;
    private final Visits visits;

    private List<PaymentEntity> nearestExpire(int plusDays) {
        return this.paymentsRepository.findByToDate(LocalDate.now().plusDays(plusDays));
    }

    private List<PaymentEntity> Expired() {
        return this.paymentsRepository.findByToDate(visits.getLastVisit());
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

    public void update() {
//        LocalDate latest = visits.getLastVisit();
//        while (!latest.equals(LocalDate.now())) {
//            for (PaymentEntity paymentEntity : Expired()) {
//                this.addNextPayment(paymentEntity);
//            }
//            latest = latest.plusDays(1);
//        }
        for (int plusDays = 0; plusDays < 14; plusDays++) {
            for (PaymentEntity paymentEntity : nearestExpire(plusDays)) {
                this.addNextPayment(paymentEntity);
            }
        }
    }

}
