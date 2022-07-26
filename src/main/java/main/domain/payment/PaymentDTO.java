package main.domain.payment;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
public class PaymentDTO {

    private String user;
    private String paymentType;
    private LocalDate from;
    private LocalDate to;
    private LocalDate term;
    private BigDecimal sum;

}
