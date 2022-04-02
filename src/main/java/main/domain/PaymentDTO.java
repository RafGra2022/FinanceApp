package main.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
public class PaymentDTO {

    private String user;
    private String paymentType;
    private LocalDateTime from;
    private LocalDateTime to;
    private LocalDateTime term;
    private BigDecimal sum;

}
