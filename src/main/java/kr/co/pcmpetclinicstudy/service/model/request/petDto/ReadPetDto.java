package kr.co.pcmpetclinicstudy.service.model.request.petDto;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReadPetDto {

    private LocalDate birthDate;

    private String petName;

    private PetsTypes petTypes;

    private String ownerName;
}
