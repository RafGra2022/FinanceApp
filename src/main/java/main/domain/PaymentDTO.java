package main.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class PaymentDTO {

    private String _user;
    private String _paymentType;
    private Date _from;
    private Date _to;
    private Date _term;
    private float _sum;

}
