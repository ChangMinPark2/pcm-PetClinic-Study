package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class PetReqDto {

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class CREATE{

        @NotBlank(message = "id를 입력해주세요")
        private Long ownerId;

        @NotBlank(message = "생년 월일을 입력해주세요")
        private LocalDate birthDate;

        @NotBlank(message = "이름을 입력해주세요")
        private String petName;

        @NotBlank(message = "애완동물의 종류를 입력해주세요")
        private String petsTypes;
    }

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
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
