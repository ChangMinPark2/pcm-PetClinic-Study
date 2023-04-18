package kr.co.pcmpetclinicstudy.service.model.response;

import kr.co.pcmpetclinicstudy.service.model.enums.PetsTypes;
import lombok.*;

import java.time.LocalDate;

public class PetResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class READ{

        private PetsTypes petType;

        private LocalDate birthDate;

        private String petName;

        private String ownerFirstName;

        private String ownerLastName;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class READ_PET_TYPE{

        private PetsTypes petsTypes;
    }
}
