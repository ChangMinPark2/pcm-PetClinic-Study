package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tbl_visits")
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visits_id", length = 4)
    private Long vId;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "visit_date")
    private LocalDate localDate;

    @ManyToOne
    @JoinColumn(name = "pets_id")
    private Pets pets;

    @Builder
    public Visits(String description,
                  LocalDate localDate,
                  Pets pets) {
        this.description = description;
        this.localDate = localDate;
        this.pets = pets;
    }
}
