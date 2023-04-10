package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialties;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VetSpecialtiesMapper {

    VetSpecialtiesMapper INSTANCE = Mappers.getMapper(VetSpecialtiesMapper.class);

    VetSpecialties toVetSpecialtiesEntity(Specialties specialties, Vet vet);

}
