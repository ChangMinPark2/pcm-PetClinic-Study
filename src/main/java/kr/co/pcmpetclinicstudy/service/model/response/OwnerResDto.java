package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OwnerResDto {

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class READ{

        private String address;

        private String city;

        private String firstName;

        private String lastName;

        private String telephone;
    }
}
