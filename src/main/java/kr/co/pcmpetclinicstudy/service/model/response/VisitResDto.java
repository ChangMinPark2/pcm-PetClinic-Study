package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.*;

import java.time.LocalDate;

public class VisitResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{

        private String description;

        private LocalDate visitDate;

        private String petName;
    }
}
