package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

@Getter
@NoArgsConstructor
@Table(name = "tbl_vetspecialties")
@Entity
@AttributeOverride(
        name = "id",
        column = @Column(name = "vetspecialties_id", length = 4)
)
public class VetSpecialties extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vets_id")
    private Vets vets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialties_id")
    private Specialties specialties;
}
