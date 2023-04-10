package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.OwnerResDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    Owner toOwnerEntity(OwnerReqDto.CREATE create);

    OwnerResDto.READ toReadDto(Owner owner);
}
