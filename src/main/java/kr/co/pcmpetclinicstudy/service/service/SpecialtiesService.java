package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.infra.error.exception.DuplicatedException;
import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.repository.SpecialtiesRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VetRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.SpecialtiesMapper;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.SpecialtiesResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpecialtiesService {

    private final VetRepository vetRepository;

    private final SpecialtiesMapper specialtiesMapper;

    private final SpecialtiesRepository specialtiesRepository;

    public void createSpecialties(SpecialtiesReqDto.CREATE create){

        final Vet vet = vetRepository.findById(create.getVetId())
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        checkSpecialtiesName(create.getSpecialtiesName());

        final Specialties specialties = specialtiesMapper.toSpecialtiesEntity(create, vet);

        specialtiesRepository.save(specialties);

    }

    /**
     * 모든 전문 분야 리스트 조회
     * */
    public List<SpecialtiesResDto.READ> readAllSpecialties(){

        List<Specialties> specialties = specialtiesRepository.findAll();

        return specialties
                .stream()
                .map(specialtiesMapper :: toReadDto)
                .collect(Collectors.toList());
    }

    /**
     * 수의사 id를 통해 Specialties 조회
     * */
    public List<SpecialtiesResDto.READ> readSpecialtiesToId(Long vetId){

        Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        List<Specialties> specialties = specialtiesRepository.findByVet(vet);

        return specialties
                .stream()
                .map(specialtiesMapper::toReadDto)
                .collect(Collectors.toList());
    }

    private void checkSpecialtiesName(String name){
        if (specialtiesRepository.existsBySpecialtiesNames(name))
            throw new DuplicatedException(ErrorCodeType.FAIL_DUPLICATED_PHONENUMBER);
    }
}
