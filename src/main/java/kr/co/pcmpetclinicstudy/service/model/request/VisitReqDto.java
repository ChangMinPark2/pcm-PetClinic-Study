package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

public class VisitReqDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CREATE{

        private Long petId;

        @NotBlank(message = "애완동물이 어디가 아픈지 기입해주십시요")
        private String description;

        @NotBlank(message = "방문일자를 입력해주세요")
        private LocalDate visitDate;
    }
}
