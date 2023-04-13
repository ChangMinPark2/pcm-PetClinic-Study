package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.*;

import java.time.LocalDate;

public class VisitResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class READ{

        private String description;

        private LocalDate visitDate;

        private String petName;

        private String ownerFirstName;

        private String ownerLastName;
    }
}
