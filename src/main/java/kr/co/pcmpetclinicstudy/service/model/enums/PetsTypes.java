package kr.co.pcmpetclinicstudy.service.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PetsTypes {

    DOG("강아지"),

    CAT("고양이");

    String petType;

    public static PetsTypes of(String petType){
        return Arrays.stream(PetsTypes.values())
                .filter(type -> type.toString().equalsIgnoreCase(petType))
                .findAny().orElseThrow(() -> new RuntimeException("Not Fount Pet Types"));
    }

}
