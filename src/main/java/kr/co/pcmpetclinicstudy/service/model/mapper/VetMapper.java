package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialty;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VetResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VetMapper {

    //source dto값, target entity값

    @Mapping(target = "firstName", source = "create.firstName")
    @Mapping(target = "lastName", source = "create.lastName")
    @Mapping(target = "vetSpecialties", source = "vetSpecialties")
    Vet toVetEntity(VetReqDto.CREATE create, List<VetSpecialty> vetSpecialties);


    @Mapping(target = "firstName", source = "vet.firstName")
    @Mapping(target = "lastName", source = "vet.lastName")
    @Mapping(target = "specialtiesName", source = "specialtiesName")
    VetResDto.READ toReadDto(Vet vet, List<String> specialtiesName);
}
