package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.*;

import java.util.List;

public class VetResDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class READ{

        private String firstName;

        private String lastName;

        private List<String> specialtiesName;
    }
}
