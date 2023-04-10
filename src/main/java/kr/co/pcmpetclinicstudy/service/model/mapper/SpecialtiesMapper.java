package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpecialtiesMapper {

    SpecialtiesMapper INSTANCE = Mappers.getMapper(SpecialtiesMapper.class);

    Specialties toSpecialtiesEntity(String name);
}
