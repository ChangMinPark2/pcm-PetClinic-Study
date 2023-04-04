package kr.co.pcmpetclinicstudy.service.model.request.visitDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateVisitDto {

    private Long petId;

    @NotBlank(message = "어디가 아픈지 기입해주십시요")
    private String description;

    @NotBlank(message = "방문일자를 입력해주세요")
    private LocalDate visitDate;

}
