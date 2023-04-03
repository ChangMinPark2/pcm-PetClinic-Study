package kr.co.pcmpetclinicstudy.service.model.request.PetDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeletePetDto {
    @NotBlank(message = "펫의 id를 입력해주세요.")
    private Long id;
}
