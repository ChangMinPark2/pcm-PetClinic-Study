package kr.co.pcmpetclinicstudy.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    OWNER_DUPLICATED(400, "주인 아이디가 중복되었습니다."),
    PET_DUPLICATED(400, "애완동물 아이디가 중복되었습니다.");

    private int status;

    private String message;
}
