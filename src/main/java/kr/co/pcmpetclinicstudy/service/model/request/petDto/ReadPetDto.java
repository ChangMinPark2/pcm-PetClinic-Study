package kr.co.pcmpetclinicstudy.service.model.request.petDto;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class ReadPetDto {

    private LocalDate birthDate;

    private String petName;

    private PetsTypes petTypes;

    private String ownerName;
}
