package kr.co.pcmpetclinicstudy.service.model.request.PetDto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.co.pcmpetclinicstudy.persistence.entity.Owners;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class ReadPetDto {

    private LocalDate birthDate;

    private String name;

    private PetsTypes petsTypes;

    private Owners owners;
}
