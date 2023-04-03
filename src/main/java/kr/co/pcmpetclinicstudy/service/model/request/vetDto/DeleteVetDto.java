package kr.co.pcmpetclinicstudy.service.model.request.vetDto;

import jakarta.validation.constraints.NotBlank;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialties;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DeleteVetDto {

    @NotBlank(message = "이름을 입력해주세요.")
    private String firstName;

    @NotBlank(message = "성을 입력해주세요")
    private String lastName;

    @NotBlank(message = "자격증을 입력해주세요.")
    private List<VetSpecialties> vetSpecialties = new ArrayList<>();
}
