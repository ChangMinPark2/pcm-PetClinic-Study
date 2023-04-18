package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.*;

import java.time.LocalDate;

public class VisitResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class READ_OWNER{

        private String description;

        private LocalDate visitDate;

        private String petName;

        private String vetFirstName;

        private String vetLastName;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class READ_PET{

        private String description;

        private LocalDate visitDate;

        private String ownerFirstName;

        private String ownerLastName;

        private String vetFirstName;

        private String vetLastName;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class READ_VET{

        private String description;

        private LocalDate visitDate;

        private String petName;

        private String ownerFirstName;

        private String ownerLastName;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class READ_DETAIL{

        private String description;

        private LocalDate visitDate;

        private String petName;

        private String ownerFirstName;

        private String ownerLastName;

        private String ownerTelephone;

        private String vetFirstName;

        private String vetLastName;
    }
}
