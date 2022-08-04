package main.controller.payment;

import main.domain.payment.PaymentDto;

import java.time.LocalDate;
import java.util.Date;

public class PaymentMapper {

    public static PaymentDto toPaymentDTO(PaymentRequest paymentRequest) {
        return PaymentDto.builder()
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
