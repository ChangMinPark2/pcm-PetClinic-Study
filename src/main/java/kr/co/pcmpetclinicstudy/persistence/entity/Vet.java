package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
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

    @OneToMany(
            mappedBy = "vets",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}
    ) //vets는 vetSpecialties를 리스트로 가지며, mappedBy를 사용함으로써 vets는 주인이 아님을 알려준다.
    private List<VetSpecialties> vetSpecialties = new ArrayList<>();

    @Builder
    public Vet(String firstName,
               String lastName,
               List<VetSpecialties> vetSpecialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vetSpecialties = vetSpecialties;
    }

//    public static Vet createOf(VetReqDto.CREATE create,
//                               List<VetSpecialties> vetSpecialties){
//        return Vet.builder()
//                .firstName(create.getFirstName())
//                .lastName(create.getLastName())
//                .vetSpecialties(vetSpecialties)
//                .build();
//    }

    public void updateVetSpecialties(List<VetSpecialties> vetSpecialties){
        this.vetSpecialties = vetSpecialties;
    }

//    public static VetResDto.READ readOf (Vet vet,
//                                    List<String> specialtiesName){
//        return VetResDto.READ.builder()
//                .firstName(vet.firstName)
//                .lastName(vet.lastName)
//                .specialtiesName(specialtiesName)
//                .build();
//    }
}
