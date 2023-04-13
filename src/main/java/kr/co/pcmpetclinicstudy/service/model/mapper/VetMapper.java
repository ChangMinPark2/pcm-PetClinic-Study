package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialties;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VetResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VetMapper {

    //source dto값, target entity값

    Vet toVetEntity(VetReqDto.CREATE create, List<VetSpecialties> vetSpecialties);

    VetResDto.READ toReadDto(Vet vet, List<String> specialtiesName);
}
