package kr.co.pcmpetclinicstudy.service.model.request.vetDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReadVetDto {

    private String firstName;

    private String lastName;

    private List<String> specialtiesName;
}
