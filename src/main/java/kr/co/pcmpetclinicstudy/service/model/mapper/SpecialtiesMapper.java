package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.SpecialtiesResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpecialtiesMapper {

    @Mapping(target = "specialtiesNames", source = "create.specialtiesName")
    @Mapping(target = "vet", source = "vet")
    Specialties toSpecialtiesEntity(SpecialtiesReqDto.CREATE create, Vet vet);

    @Mapping(target = "specialtiesName", source = "specialties.specialtiesNames")
    SpecialtiesResDto.READ toReadDto (Specialties specialties);
}
