package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class VetReqDto {

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class CREATE{

        @NotBlank(message = "이름을 입력해주세요.")
        private String firstName;

        @NotBlank(message = "성을 입력해주세요")
        private String lastName;

        @NotBlank(message = "자격증을 입력해주세요.")
        private List<String> specialtiesName;
    }

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class UPDATE{

        private Long vetId;

        @NotBlank(message = "이름을 입력해주세요.")
        private String firstName;

        @NotBlank(message = "성을 입력해주세요")
        private String lastName;

        @NotBlank(message = "자격증을 입력해주세요")
        private List<String> specialtiesName;
    }
}
