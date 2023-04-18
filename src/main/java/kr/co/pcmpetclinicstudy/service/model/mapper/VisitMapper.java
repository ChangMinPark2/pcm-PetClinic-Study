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
    @Mapping(target = "owner", source = "owner")
    @Mapping(target = "vet", source = "vet")
    Visit toVisitEntity(VisitReqDto.CREATE create, Pet pet, Owner owner, Vet vet);

    @Mapping(target = "visitDate", source = "visit.visitDate")
    @Mapping(target = "description", source = "visit.description")
    @Mapping(target = "petName", source = "visit.pet.petName")
    @Mapping(target = "vetFirstName", source = "visit.vet.firstName")
    @Mapping(target = "vetLastName", source = "visit.vet.lastName")
    VisitResDto.READ_OWNER toReadOwner(Visit visit);

    @Mapping(target = "visitDate", source = "visit.visitDate")
    @Mapping(target = "description", source = "visit.description")
    @Mapping(target = "ownerFirstName", source = "visit.owner.firstName")
    @Mapping(target = "ownerLastName", source = "visit.owner.lastName")
    @Mapping(target = "vetFirstName", source = "visit.vet.firstName")
    @Mapping(target = "vetLastName", source = "visit.vet.lastName")
    VisitResDto.READ_PET toReadPet(Visit visit);

    @Mapping(target = "visitDate", source = "visit.visitDate")
    @Mapping(target = "description", source = "visit.description")
    @Mapping(target = "petName", source = "visit.pet.petName")
    @Mapping(target = "ownerFirstName", source = "visit.owner.firstName")
    @Mapping(target = "ownerLastName", source = "visit.owner.lastName")
    VisitResDto.READ_VET toReadVet(Visit visit);

    @Mapping(target = "petName", source = "visit.pet.petName")
    @Mapping(target = "description", source = "visit.description")
    @Mapping(target = "ownerFirstName", source = "visit.owner.firstName")
    @Mapping(target = "ownerLastName", source = "visit.owner.lastName")
    @Mapping(target = "ownerTelephone", source = "visit.owner.telephone")
    @Mapping(target = "vetFirstName", source = "visit.vet.firstName")
    @Mapping(target = "vetLastName", source = "visit.vet.lastName")
    @Mapping(target = "visitDate", source = "visit.visitDate")
    VisitResDto.READ_DETAIL toReadDetailDto(Visit visit);
}
