package main.repository.model;

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

    public VisitsEntity(LocalDate visit){
        this.visit = visit;
    }
}
