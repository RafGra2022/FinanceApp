package main.controller.payment;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
public class PaymentRequest {


    private String _user;
    private String _paymentType;
    private Date _from;
    private Date _to;
    private Date _term;
    private BigDecimal _sum;

}
