package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class VisitReqDto {
    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class CREATE{

        private Long petId;

        @NotBlank(message = "애완동물이 어디가 아픈지 기입해주십시요")
        private String description;

        @NotBlank(message = "방문일자를 입력해주세요")
        private LocalDate visitDate;
    }
    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class DELETE{

        private Long id;
    }
}
