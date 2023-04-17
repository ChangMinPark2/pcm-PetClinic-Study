package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.repository.SpecialtiesRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VetRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.SpecialtiesMapper;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialtiesService {

    private final VetRepository vetRepository;

    private final SpecialtiesMapper specialtiesMapper;

    private final SpecialtiesRepository specialtiesRepository;

    public void createSpecialties(SpecialtiesReqDto.CREATE create){

        final Vet vet = vetRepository.findById(create.getVetId())
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final Specialties specialties = specialtiesMapper.toSpecialtiesEntity(create, vet);

        specialtiesRepository.save(specialties);

    }

}
