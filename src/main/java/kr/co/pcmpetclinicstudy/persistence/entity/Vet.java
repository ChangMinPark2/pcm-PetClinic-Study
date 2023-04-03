package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.CreateVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.ReadVetDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "vets") //vets는 vetSpecialties를 리스트로 가지며, mappedBy를 사용함으로써 vets는 주인이 아님을 알려준다.
    List<VetSpecialties> vetSpecialties = new ArrayList<>();

    @Builder
    public Vet(String firstName,
               String lastName,
               List<VetSpecialties> vetSpecialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vetSpecialties = vetSpecialties;
    }

    public static Vet of(CreateVetDto createVetDto){
        return Vet.builder()
                .firstName(createVetDto.getFirstName())
                .lastName(createVetDto.getLastName())
                .vetSpecialties(createVetDto.getVetSpecialties())
                .build();
    }

    public void updateVet(String firstName,
                          String lastName,
                          List<VetSpecialties> vetSpecialties){
        this.firstName = firstName;
        this.lastName = lastName;
        this.vetSpecialties = vetSpecialties;
    }

    public static ReadVetDto of (Vet vet){
        return ReadVetDto.builder()
                .firstName(vet.firstName)
                .lastName(vet.lastName)
                .vetSpecialties(vet.vetSpecialties)
                .build();
    }
}
