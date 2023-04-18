package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_specialties")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AttributeOverride(
        name = "id",
        column = @Column(name = "specialties_id", length = 4)
)
public class Specialties extends BaseEntity {

    @Column(name = "specialties_name", length = 80)
    private String specialtiesNames;

    @OneToMany(
            mappedBy = "specialties",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<VetSpecialties> vetSpecialties = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vets_id")
    private Vet vet;

    @Builder
    private Specialties(String specialtiesNames,
                        Vet vet) {
        this.specialtiesNames = specialtiesNames;
        this.vet = vet;
    }

    public void updateSpecialtiesName(String specialtiesNames){
        this.specialtiesNames = specialtiesNames;
    }
}
