package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.PetResDto;
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

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "pets_types")
    private PetsTypes petsType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owners_id")
    private Owner owner;

    @Builder
    public Pet(LocalDate birthDate,
               String name,
               Owner owners,
               PetsTypes petsTypes) {
        this.birthDate = birthDate;
        this.name = name;
        this.owner = owners;
        this.petsType = petsTypes;
    }

    public static Pet createOf(PetReqDto.CREATE create, Owner owner){
        return Pet.builder()
                .birthDate(create.getBirthDate())
                .name(create.getName())
                .owners(owner)
                .petsTypes(PetsTypes.valueOf(create.getPetsTypes()))
                .build();
    }

    public void updatePet(PetReqDto.UPDATE update){
        this.birthDate = update.getBirthDate();
        this.name = update.getName();
        this.petsType = PetsTypes.valueOf(update.getPetsTypes());
    }

    public static PetResDto.READ readOf(Pet pets){
        return PetResDto.READ.builder()
                .birthDate(pets.birthDate)
                .petName(pets.name)
                .ownerName(pets.owner.getFirstName() + pets.owner.getLastName())
                .petTypes(pets.petsType)
                .build();
    }
}
