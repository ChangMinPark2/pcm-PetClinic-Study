package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.Visit;
import kr.co.pcmpetclinicstudy.service.model.request.VisitReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VisitResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    @Mapping(target = "visitDate", source = "create.visitDate")
    @Mapping(target = "description", source = "create.description")
    @Mapping(target = "pet", source = "pet")
    @Mapping(target = "vet", source = "vet")
    @Mapping(target = "owner", source = "owner")
    Visit toVisitEntity(VisitReqDto.CREATE create, Pet pet, Vet vet, Owner owner);

    @Mapping(target = "visitDate", source = "visit.visitDate")
    @Mapping(target = "description", source = "visit.description")
    @Mapping(target = "petName", source = "visit.pet.petName")
    VisitResDto.READ toReadDto(Visit visit);
}
