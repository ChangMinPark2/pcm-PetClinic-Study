package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

public class VisitResDto {

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class READ{

        private String description;

        private LocalDate visitDate;

        private String petName;
    }
}
