package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.PetResDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet createOf(PetReqDto.CREATE create, Owner owner);

    PetResDto.READ readOf(Pet pet);
}
