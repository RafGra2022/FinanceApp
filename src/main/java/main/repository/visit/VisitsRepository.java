package main.repository.visit;

import main.repository.visit.VisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("visitsRepository")
public interface VisitsRepository extends JpaRepository<VisitsEntity,Long> {

}
