package main.repository;

import main.repository.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("paymentsRepository")
public interface PaymentsRepository extends JpaRepository<PaymentEntity,Long> {

}
