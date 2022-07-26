package main.domain.visit;

import lombok.AllArgsConstructor;
import main.repository.visit.VisitsRepository;
import main.repository.visit.VisitsEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@Component
public class Visits {

    private final VisitsRepository visitsRepository;

    public LocalDate getLastVisit() {
        LocalDate date = LocalDate.of(2022,1,1);
        ArrayList<VisitsEntity> visits = new ArrayList<VisitsEntity>(this.visitsRepository.findAll());
        for (VisitsEntity visitsEntity : visits) {
            if(visitsEntity.getVisit().isAfter(date)){
                date = visitsEntity.getVisit();
            }
        }
        return date;
    }

//    public LocalDate getLastUpdate() {
//        LocalDate date = LocalDate.of(2022,1,1);
//        ArrayList<VisitsEntity> visits = new ArrayList<VisitsEntity>(this.visitsRepository.findAll());
//        for (VisitsEntity visitsEntity : visits) {
//            if(visitsEntity.getLastUpdate().isAfter(date)){
//                date = visitsEntity.getLastUpdate();
//            }
//        }
//        return date;
//    }

//    public int difference(){
//        int daysAmount = 0;
//        LocalDate lastUpdate = this.getLastUpdate();
//        while(!lastUpdate.equals(LocalDate.now())){
//            lastUpdate = lastUpdate.plusDays(1);
//            daysAmount++;
//        }
//        return daysAmount;
//    }

}
