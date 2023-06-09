package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_vets")
@AttributeOverride( //컬럼 명 속성 재 정의
        name = "id",
        column = @Column(name = "vets_id", length = 4)
)
public class Vet extends BaseEntity {

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

   // vets는 vetSpecialties를 리스트로 가지며, mappedBy를 사용함으로써 vets는 주인이 아님을 알려준다.
    @OneToMany(
            mappedBy = "vet",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<VetSpecialty> vetSpecialties = new ArrayList<>();

    @Builder
    public Vet(String firstName,
               String lastName,
               List<VetSpecialty> vetSpecialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vetSpecialties = vetSpecialties;
    }

    public void updateVetSpecialties(List<VetSpecialty> vetSpecialties){
        this.vetSpecialties = vetSpecialties;
    }

}
