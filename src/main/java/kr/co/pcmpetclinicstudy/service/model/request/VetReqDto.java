package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

public class VetReqDto {

    @Getter
    @AllArgsConstructor
    public static class CONDITION{

        private List<Long> ids;
    }

    @Getter
    @AllArgsConstructor
    public static class CONDITION_SPECIALTY_NAME{
        private List<String> specialtyName;
    }
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CREATE{

        @NotBlank(message = "이름을 입력해주세요.")
        private String firstName;

        @NotBlank(message = "성을 입력해주세요")
        private String lastName;

        @NotEmpty(message = "학위를 입력해주세요")
        private Set<String> specialtiesName;

    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ADD_DELETE{

        private Set<String> specialtiesName;
    }
}
