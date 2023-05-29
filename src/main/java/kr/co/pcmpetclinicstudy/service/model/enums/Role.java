package kr.co.pcmpetclinicstudy.service.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Role {

    USER_ROLE("일반"),

    ADMIN_ROLE("관리자");

    String role;

    public static PetsTypes of(String role){
        return Arrays.stream(PetsTypes.values())
                .filter(type -> type.toString().equalsIgnoreCase(role))
                .findAny().orElseThrow(() -> new RuntimeException("Not Fount Role"));
    }
}
