package main.repository;

import main.repository.model.VisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("visitsRepository")
public interface VisitsRepository extends JpaRepository<VisitsEntity,Long> {

}
