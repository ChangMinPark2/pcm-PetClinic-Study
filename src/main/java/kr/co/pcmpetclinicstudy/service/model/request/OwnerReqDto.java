package kr.co.pcmpetclinicstudy.service.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class OwnerReqDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UPDATE{

        @NotBlank(message = "주인 id가 필요합니다.")
        private Long ownerId;

        private String address;

        private String city;

        private String firstName;

        private String lastName;

        @NotBlank(message = "전화번호를 입력해주세요")
        private String telephone;

    }
}
