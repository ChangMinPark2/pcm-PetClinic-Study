package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_pets")
@Getter
@NoArgsConstructor
@AttributeOverride( //컬럼 명 속성 재 정의
        name = "id",
        column = @Column(name = "pets_id", length = 4)
)
public class Pets extends BaseEntity {

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "pets_types")
    private PetsTypes petsTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owners_id")
    private Owners owners;

    @Builder
    public Pets(LocalDate birthDate,
                String name,
                Owners owners,
                PetsTypes petsTypes) {
        this.birthDate = birthDate;
        this.name = name;
        this.owners = owners;
        this.petsTypes = petsTypes;
    }
}
