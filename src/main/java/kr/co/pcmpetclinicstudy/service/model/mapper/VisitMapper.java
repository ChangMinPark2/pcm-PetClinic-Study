package kr.co.pcmpetclinicstudy.service.model.mapper;

import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.Visit;
import kr.co.pcmpetclinicstudy.service.model.request.VisitReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VisitResDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    Visit createOf(VisitReqDto.CREATE create, Pet pet);

    VisitResDto.READ readOf(Visit visit);
}
