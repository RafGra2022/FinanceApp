package main.repository.payment;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name= "user_name")
    private String user;

    private String paymentType;

    private LocalDate fromDate;

    private LocalDate toDate;

    private LocalDate term;

    private BigDecimal sum;

}
