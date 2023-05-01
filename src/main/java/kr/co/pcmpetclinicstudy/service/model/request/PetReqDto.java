package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

public class PetReqDto {

    @Getter
    @AllArgsConstructor
    public static class CONDITION{

        private List<Long> ids;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CREATE{

        @NotNull(message = "id를 입력해주세요")
        private Long ownerId;

        private LocalDate birthDate;

        @NotBlank(message = "이름을 입력해주세요")
        private String petName;

        @NotBlank(message = "애완동물의 종류를 입력해주세요")
        private String petsTypes;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UPDATE{

        @NotBlank(message = "id를 입력해주세요")
        private Long petId;

        @NotBlank(message = "생년 월일을 입력해주세요")
        private LocalDate birthDate;

        @NotBlank(message = "이름을 입력해주세요")
        private String petName;

        @NotBlank(message = "애완동물의 종류를 입력해주세요")
        private String petsTypes;
    }
}
