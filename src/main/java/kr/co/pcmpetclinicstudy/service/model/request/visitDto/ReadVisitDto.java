package kr.co.pcmpetclinicstudy.service.model.request.visitDto;

import lombok.Builder;
import java.time.LocalDate;

@Builder
public class ReadVisitDto {

    private String description;

    private LocalDate visitDate;

    private String petName;
}
