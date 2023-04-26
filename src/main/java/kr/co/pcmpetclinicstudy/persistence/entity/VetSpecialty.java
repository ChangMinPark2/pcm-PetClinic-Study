package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_vets_specialties")
@Entity
@AttributeOverride(
        name = "id",
        column = @Column(name = "vet_specialties_id", length = 4)
)
public class VetSpecialty extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vets_id")
    private Vet vet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialties_id")
    private Specialty specialty;

    @Builder
    public VetSpecialty(Vet vet,
                        Specialty specialty) {
        this.vet = vet;
        this.specialty = specialty;
    }
}
