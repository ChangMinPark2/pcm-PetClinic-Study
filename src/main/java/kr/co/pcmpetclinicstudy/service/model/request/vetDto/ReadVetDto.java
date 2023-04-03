package kr.co.pcmpetclinicstudy.service.model.request.vetDto;

import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialties;
import lombok.Builder;
import java.util.ArrayList;
import java.util.List;

@Builder
public class ReadVetDto {

    private String firstName;

    private String lastName;

    List<VetSpecialties> vetSpecialties = new ArrayList<>();
}
