package main.domain;

import lombok.AllArgsConstructor;
import main.repository.VisitsRepository;
import main.repository.model.VisitsEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class Init {

    private final VisitsRepository visitsRepository;

    @PostConstruct
    public void init() {
        if(!this.getLastVisit().equals(LocalDate.now())){
            this.visitsRepository.save(new VisitsEntity(LocalDate.now()));
        }
        System.out.println(this.getLastVisit());
    }

    private LocalDate getLastVisit() {
        LocalDate date = LocalDate.of(2022,1,1);
        ArrayList<VisitsEntity> visits = new ArrayList<VisitsEntity>(this.visitsRepository.findAll());
        for (VisitsEntity visitsEntity : visits) {
            if(visitsEntity.getVisit().isAfter(date)){
                date = visitsEntity.getVisit();
            }
        }
        return date;
    }
}
