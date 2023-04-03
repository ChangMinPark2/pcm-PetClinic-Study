package kr.co.pcmpetclinicstudy.service.model.request.PetDto;

import jakarta.validation.constraints.NotBlank;
import kr.co.pcmpetclinicstudy.persistence.entity.Owners;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class UpdatePetDto {

    @NotBlank(message = "id를 입력해주세요")
    private Long id;

    @NotBlank(message = "생년 월일을 입력해주세요")
    private LocalDate birthDate;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @NotBlank(message = "애완동물의 종류를 입력해주세요")
    private PetsTypes petsTypes;

    @NotBlank(message = "주인의 id를 입력해주세요")
    private Owners owners;
}
