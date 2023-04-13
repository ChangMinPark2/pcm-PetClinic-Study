package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.OwnerResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")//빌드 시 구현체 만들고 빈으로 등록한다.
public interface OwnerMapper {

    //OwnerReqDtoCreate create -> Owner 매핑

    Owner toOwnerEntity(OwnerReqDto.CREATE create);

    //Owner owner -> OwnerResDto.Read DTo
    OwnerResDto.READ toReadDto(Owner owner);
}
