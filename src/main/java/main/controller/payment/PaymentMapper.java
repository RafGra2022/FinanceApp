package main.controller.payment;

import main.domain.payment.PaymentDTO;

import java.time.LocalDate;
import java.util.Date;

public class PaymentMapper {

    public static PaymentDTO toPaymentDTO(PaymentRequest paymentRequest) {
        return PaymentDTO.builder()
                .user(paymentRequest.get_user())
                .paymentType(paymentRequest.get_paymentType())
                .from(dateConverter(paymentRequest.get_from()))
                .to(dateConverter(paymentRequest.get_to()))
                .term(dateConverter(paymentRequest.get_term()))
                .sum(paymentRequest.get_sum()).build();
    }
    private static LocalDate dateConverter(Date dateToConvert) {
        return new java.sql.Timestamp(
                dateToConvert.getTime()).toLocalDateTime().toLocalDate();}

}
