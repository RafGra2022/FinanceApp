package main.controller;

import main.domain.PaymentDTO;

import java.time.LocalDateTime;
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
    private static LocalDateTime dateConverter(Date dateToConvert) {
        return new java.sql.Timestamp(
                dateToConvert.getTime()).toLocalDateTime();}

}
