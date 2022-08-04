package main.repository.payment;

import main.domain.payment.PaymentDto;

public class PaymentMapper {

    private PaymentMapper(){}


    public static PaymentEntity mapToPaymentEntity(PaymentDto paymentDTO) {
        PaymentEntity payments = new PaymentEntity();
        payments.setUser(paymentDTO.getUser());
        payments.setPaymentType(paymentDTO.getPaymentType());
        payments.setFromDate(paymentDTO.getFrom());
        payments.setToDate(paymentDTO.getTo());
        payments.setTerm(paymentDTO.getTerm());
        payments.setSum(paymentDTO.getSum());
        return payments;
//        this.paymentsRepository.save(payments);
    }



}
