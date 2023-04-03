package kr.co.pcmpetclinicstudy.service.model.request.visitDto;

import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class ReadVisitDto {

    private String description;

    private LocalDate visitDate;

    private Pet pets;
}
