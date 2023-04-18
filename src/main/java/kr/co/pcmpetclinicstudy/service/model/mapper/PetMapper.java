package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.PetResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(target = "petName", source = "create.petName")
    @Mapping(target = "birthDate", source = "create.birthDate")
    @Mapping(target = "petsTypes", source = "create.petsTypes")
    @Mapping(target = "owner", source = "owner")
    Pet toPetEntity(PetReqDto.CREATE create, Owner owner);

    @Mapping(target = "petName", source = "pet.petName")
    @Mapping(target = "petType", source = "pet.petsType")
    @Mapping(target = "birthDate", source = "pet.birthDate")
    @Mapping(target = "ownerFirstName", source = "pet.owner.firstName")
    @Mapping(target = "ownerLastName", source = "pet.owner.lastName")
    PetResDto.READ toReadDto(Pet pet);

    @Mapping(target = "petsTypes", source = "pet.petsType")
    PetResDto.READ_PET_TYPE toReadDtoPetTypes(Pet pet);
}
