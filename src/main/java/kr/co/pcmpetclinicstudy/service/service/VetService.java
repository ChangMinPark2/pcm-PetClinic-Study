package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Specialties;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialties;
import kr.co.pcmpetclinicstudy.persistence.repository.SpecialtiesRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VetRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.SpecialtiesMapper;
import kr.co.pcmpetclinicstudy.service.model.mapper.VetMapper;
import kr.co.pcmpetclinicstudy.service.model.mapper.VetSpecialtiesMapper;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VetResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VetService {

    private final VetRepository vetRepository;

    private final SpecialtiesRepository specialtiesRepository;

    private final VetMapper vetMapper;

    private final VetSpecialtiesMapper vetSpecialtiesMapper;

    private final SpecialtiesMapper specialtiesMapper;

    @Transactional
    public void createVet(VetReqDto.CREATE create){

        Vet vet = vetMapper.toVetEntity(create);

        vetRepository.save(vet);
    }

    public VetResDto.READ readVetDto(Long vetId){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final List<String> specialtiesName = getSpecialtiesNameByVet(vet);

        return vetMapper.toReadDto(vet, specialtiesName);
    }


    public void deleteVet(Long vetId){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        vetRepository.delete(vet);
    }

    /**
     * Specialties -> name 추출 메소드
     * */
    private List<String> getSpecialtiesNameByVet(Vet vet){

        return specialtiesRepository.findByVet(vet)
                .stream()
                .map(Specialties::getSpecialtiesNames)
                .collect(Collectors.toList());
    }

}
