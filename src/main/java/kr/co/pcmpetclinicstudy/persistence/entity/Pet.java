package kr.co.pcmpetclinicstudy.persistence.entity;

import jakarta.persistence.*;
import kr.co.pcmpetclinicstudy.persistence.BaseEntity;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.ReadPetDto;
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
    private PetsTypes petsTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owners_id")
    private Owners owners;

    @Builder
    public Pet(LocalDate birthDate,
               String name,
               Owners owners,
               PetsTypes petsTypes) {
        this.birthDate = birthDate;
        this.name = name;
        this.owners = owners;
        this.petsTypes = petsTypes;
    }

    public static Pet of(CreatePetDto createPetDto){
        return Pet.builder()
                .birthDate(createPetDto.getBirthDate())
                .name(createPetDto.getName())
                .owners(createPetDto.getOwners())
                .petsTypes(createPetDto.getPetsTypes())
                .build();
    }

    public void updatePet(LocalDate birthDate,
                          String name,
                          Owners owners,
                          PetsTypes petsTypes){
        this.birthDate = birthDate;
        this.name = name;
        this.owners = owners;
        this.petsTypes = petsTypes;
    }

    public static ReadPetDto of(Pet pets){
        return ReadPetDto.builder()
                .birthDate(pets.birthDate)
                .name(pets.name)
                .owners(pets.owners)
                .petsTypes(pets.petsTypes)
                .build();
    }
}
