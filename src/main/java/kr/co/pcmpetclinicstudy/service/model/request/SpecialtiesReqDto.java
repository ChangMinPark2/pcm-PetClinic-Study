package kr.co.pcmpetclinicstudy.service.model.request;

import lombok.*;

public class SpecialtiesReqDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class  CREATE{
        private Long vetId;

        private String specialtiesName;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class  UPDATE{
        private Long vetId;

        private Long specialtiesId;

        private String specialtiesName;
    }
}
