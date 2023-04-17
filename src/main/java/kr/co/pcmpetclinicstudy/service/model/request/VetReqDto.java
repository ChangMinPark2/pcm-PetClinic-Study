package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

public class VetReqDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CREATE{

        @NotBlank(message = "이름을 입력해주세요.")
        private String firstName;

        @NotBlank(message = "성을 입력해주세요")
        private String lastName;
//
//        @NotEmpty(message = "자격증을 입력해주세요.")
//        private List<String> specialtiesName;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
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
