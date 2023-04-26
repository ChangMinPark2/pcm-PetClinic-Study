package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialty;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialty;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.SpecialtiesResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpecialtiesMapper {


    @Mapping(target = "specialtiesNames", source = "name")
    Specialty toSpecialtyEntity(String name);

    @Mapping(target = "specialtiesName", source = "specialty.specialtiesNames")
    SpecialtiesResDto.READ toReadDto (Specialty specialty);
}
