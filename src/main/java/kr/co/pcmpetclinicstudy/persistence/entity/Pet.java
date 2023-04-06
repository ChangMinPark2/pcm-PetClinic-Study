package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.ReadPetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.UpdatePetDto;
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

    public static Pet createOf(CreatePetDto createPetDto, Owner owner){
        return Pet.builder()
                .birthDate(createPetDto.getBirthDate())
                .name(createPetDto.getName())
                .owners(owner)
                .petsTypes(PetsTypes.valueOf(createPetDto.getPetsTypes()))
                .build();
    }

    public void updatePet(UpdatePetDto updatePetDto){
        this.birthDate = updatePetDto.getBirthDate();
        this.name = updatePetDto.getName();
        this.petsType = PetsTypes.valueOf(updatePetDto.getPetsTypes());
    }

    public static ReadPetDto readOf(Pet pets){
        return ReadPetDto.builder()
                .birthDate(pets.birthDate)
                .petName(pets.name)
                .ownerName(pets.owner.getFirstName() + pets.owner.getLastName())
                .petTypes(pets.petsType)
                .build();
    }
}
