package main.repository.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

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

    private LocalDateTime fromDate;

    private LocalDateTime toDate;

    private LocalDateTime term;

    private BigDecimal sum;

//    public Payment(String user, Date from, Date to, Date term, Float sum){
//        this.user=user;
//        this.payment=payment;
//        this.from=from;
//        this.to=to;
//        this.term=term;
//        this.sum=sum;
//    }
//    protected Payment(){}
}
