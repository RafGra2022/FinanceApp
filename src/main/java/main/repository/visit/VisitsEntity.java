package main.repository.visit;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
@Data
@NoArgsConstructor
public class VisitsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate visit;

    private LocalDate lastUpdate;

    public VisitsEntity(LocalDate visit){
        this.visit = visit;
    }
}
