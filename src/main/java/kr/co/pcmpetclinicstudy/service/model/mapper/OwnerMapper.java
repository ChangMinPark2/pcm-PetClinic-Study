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
    @Mapping(target = "firstName", source = "create.firstName")
    @Mapping(target = "lastName", source = "create.lastName")
    @Mapping(target = "address", source = "create.address")
    @Mapping(target = "city", source = "create.city")
    @Mapping(target = "telephone", source = "create.telephone")
    Owner toOwnerEntity(OwnerReqDto.CREATE create);

    //Owner owner -> OwnerResDto.Read DTo
    @Mapping(target = "firstName", source = "owner.firstName")
    @Mapping(target = "lastName", source = "owner.lastName")
    @Mapping(target = "address", source = "owner.address")
    @Mapping(target = "city", source = "owner.city")
    @Mapping(target = "telephone", source = "owner.telephone")
    OwnerResDto.READ toReadDto(Owner owner);
}
