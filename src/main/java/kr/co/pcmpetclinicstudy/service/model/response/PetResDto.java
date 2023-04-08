package kr.co.pcmpetclinicstudy.service.model.response;

import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class PetResDto {

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class READ{

        private LocalDate birthDate;

        private String petName;

        private PetsTypes petTypes;

        private String ownerName;
    }
}
