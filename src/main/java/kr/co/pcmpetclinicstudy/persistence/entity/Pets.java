package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_pets")
@Getter
@NoArgsConstructor
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pets_id", length = 4)
    private Long pId;

    @Column(name = "birth_date")
    private LocalDate localDate;

    @Column(name = "name", length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owners_id")
    private Owners owners;

    @Builder
    public Pets(LocalDate localDate,
                String name,
                Owners owners) {
        this.localDate = localDate;
        this.name = name;
        this.owners = owners;
    }
}
