package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_visits")
@AttributeOverride( //컬럼 명 속성 재 정의
        name = "id",
        column = @Column(name = "visits_id", length = 4)
)
public class Visit extends BaseEntity {

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pets_id")
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vets_id")
    private Vet vet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owners_id")
    private Owner owner;


    @Builder
    public Visit(String description,
                 LocalDate visitDate,
                 Pet pet,
                 Vet vet,
                 Owner owner) {
        this.description = description;
        this.visitDate = visitDate;
        this.pet = pet;
        this.vet = vet;
        this.owner = owner;
    }
}
