package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.*;

public class SpecialtiesResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class READ{

        private String specialtiesName;
    }
}
