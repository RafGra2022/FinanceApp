package main.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository("paymentsRepository")
public interface PaymentsRepository extends JpaRepository<PaymentEntity,Long> {

    List<PaymentEntity> findByUser(String user);
    List<PaymentEntity> findByToDate(LocalDate date);
}

