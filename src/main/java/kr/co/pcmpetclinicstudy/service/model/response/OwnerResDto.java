package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.*;

public class OwnerResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{

        private String address;

        private String city;

        private String firstName;

        private String lastName;

        private String telephone;
    }
}
