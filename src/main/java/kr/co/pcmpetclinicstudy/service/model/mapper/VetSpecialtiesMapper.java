package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Specialty;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VetSpecialtiesMapper {

    @Mapping(target = "vet", source = "vet")
    @Mapping(target = "specialty", source = "specialty")
    VetSpecialty toVetSpecialtiesEntity(Specialty specialty, Vet vet);

}
