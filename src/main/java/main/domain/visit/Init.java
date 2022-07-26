package main.domain.visit;

import lombok.AllArgsConstructor;
import main.domain.payment.PaymentsService;
import main.repository.visit.VisitsRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Init {

    private final VisitsRepository visitsRepository;
    private final PaymentsService paymentsService;
    private final Visits visits;

//    @PostConstruct
//    public void init() {
//
//        if(visits.difference()>14){}
//        this.paymentsService.update();
//        VisitsEntity visitsEntity = new VisitsEntity(LocalDate.now());
//        visitsEntity.setLastUpdate(LocalDate.now());

//        if(!this.visits.getLastVisit().equals(LocalDate.now())){
//            if(this.visits.difference()>14){
//                VisitsEntity visitsEntity = new VisitsEntity(LocalDate.now());
//                visitsEntity.setLastUpdate(LocalDate.now());
//
//                this.visitsRepository.save(visitsEntity);
//            }
//            else {
//                this.visitsRepository.save(new VisitsEntity(LocalDate.now()));
//            }
//        }
//        this.paymentsService.update();
//        System.out.println(this.visits.getLastVisit());
    }




