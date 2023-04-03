package kr.co.pcmpetclinicstudy.service.model.request.ownerDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateOwnerDto {

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
