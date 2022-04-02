package main.repositories;

import main.entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("paymentsRepository")
public interface PaymentsRepository extends JpaRepository<Payments,Integer> {

}
