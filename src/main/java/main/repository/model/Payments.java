package main.repository.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payments")
@Data
@Setter
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name= "user_name")
    private String user;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name = "term")
    private Date term;

    @Column(name = "sum")
    private Float sum;

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
