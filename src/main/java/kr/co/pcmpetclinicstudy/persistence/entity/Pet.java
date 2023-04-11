package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.enums.PetsTypes;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
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
public class Pet extends BaseEntity {

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "pet_name", length = 30)
    private String petName;

    @Column(name = "pets_types")
    private PetsTypes petsType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owners_id")
    private Owner owner;

    @Builder
    public Pet(LocalDate birthDate,
               String petName,
               PetsTypes petsTypes,
               Owner owner) {
        this.birthDate = birthDate;
        this.petName = petName;
        this.petsType = petsTypes;
        this.owner = owner;
    }

    public void updatePet(PetReqDto.UPDATE update){
        this.birthDate = update.getBirthDate();
        this.petName = update.getPetName();
        this.petsType = PetsTypes.valueOf(update.getPetsTypes());
    }

}
