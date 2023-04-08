package kr.co.pcmpetclinicstudy.service.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

public class VetResDto {

    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    @Builder
    public static class READ{

        private String firstName;

        private String lastName;

        private List<String> specialtiesName;
    }
}
