package kr.co.pcmpetclinicstudy.service.model.response;

import kr.co.pcmpetclinicstudy.service.model.enums.PetsTypes;
import lombok.*;

import java.time.LocalDate;

public class PetResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{

        private LocalDate birthDate;

        private String petName;

        private PetsTypes petTypes;

        private String ownerName;
    }
}
