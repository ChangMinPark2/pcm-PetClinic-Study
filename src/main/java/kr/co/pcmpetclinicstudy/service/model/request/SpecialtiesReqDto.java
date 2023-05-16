package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

public class SpecialtiesReqDto {

    @Getter
    @AllArgsConstructor
    public static class CONDITION{

        private List<Long> ids;
    }
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class  CREATE{

        @NotNull(message = "애완동물 Id를 입력하지 않으셨습니다.")
        private Long vetId;

        @NotBlank(message = "자격증 이름을 입력하지 않으셨습니다.")
        private String specialtiesName;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class  UPDATE{

        @NotNull(message = "애완동물 Id를 입력하지 않으셨습니다.")
        private Long vetId;

        @NotNull(message = "자격증 Id를 입력하지 않으셨습니다.")
        private Long specialtiesId;

        @NotBlank(message = "자격증 이름을 입력하지 않으셨습니다.")
        private String specialtiesName;
    }
}
