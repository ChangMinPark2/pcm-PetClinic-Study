package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OwnerReqDto {

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class CREATE{

        @NotBlank(message = "주소를 입력해주세요.")
        private String address;

        @NotBlank(message = "거주 지역을 입력해주세요")
        private String city;

        @NotBlank(message = "이름을 입력해주세요.")
        private String firstName;

        @NotBlank(message = "성을 입력해주세요")
        private String lastName;

        @NotBlank(message = "전화번호를 입력해주세요")
        private String telephone;
    }

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class UPDATE{
        private Long id;

        private String address;

        private String city;

        private String firstName;

        private String lastName;

        private String telephone;

    }
}
