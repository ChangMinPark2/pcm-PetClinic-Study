package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpecialtiesMapper {

    @Mapping(target = "specialtiesNames", source = "create.specialtiesName")
    @Mapping(target = "vet", source = "vet")
    Specialties toSpecialtiesEntity(SpecialtiesReqDto.CREATE create, Vet vet);
}
