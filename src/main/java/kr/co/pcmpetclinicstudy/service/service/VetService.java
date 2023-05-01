package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.infra.error.exception.SpecialtiesNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Specialty;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.VetSpecialty;
import kr.co.pcmpetclinicstudy.persistence.repository.SpecialtyRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VetRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VetSpecialtiesRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.search.VetSearchRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.SpecialtiesMapper;
import kr.co.pcmpetclinicstudy.service.model.mapper.VetMapper;
import kr.co.pcmpetclinicstudy.service.model.mapper.VetSpecialtiesMapper;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VetResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VetService {

    private final VetRepository vetRepository;

    private final SpecialtyRepository specialtyRepository;

    private final VetSpecialtiesRepository vetSpecialtiesRepository;

    private final VetMapper vetMapper;

    private final VetSpecialtiesMapper vetSpecialtiesMapper;

    private final SpecialtiesMapper specialtiesMapper;

    private final VetSearchRepository vetSearchRepository;

    /**
     * Vet 생성 서비스 메소드
     * vet이름, 학위 명(연관 관계 테이블을 이용해 학위 테이블을 가져온다.)
     * */
    @Transactional
    public void createVet(VetReqDto.CREATE create){

        Vet vet = vetMapper.toVetEntity(create, Collections.emptyList());

        final List<VetSpecialty> vetSpecialties = getOrCreateVetSpecialties(create.getSpecialtiesName(), vet);

        vet.updateVetSpecialties(vetSpecialties);

        vetSpecialtiesRepository.saveAll(vetSpecialties);

        vetRepository.save(vet);

    }

    /**
     * Vet 조회 서비스
     * vetId를 통해 조회한다.
     * */
    public VetResDto.READ readVetDto(Long vetId){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final List<String> specialtiesName = getSpecialtiesNameByVet(vet);

        return vetMapper.toReadDto(vet, specialtiesName);
    }

    /**
     * 수의사들이 가지고있는 모든 학위를 반환한다.
     * findAll() 사용
     * */
    public Set<String> getVetSpecialties(){

        final Set<VetSpecialty> vetSpecialties = new HashSet<>(vetSpecialtiesRepository.findAll());

        return vetSpecialties
                .stream()
                .map(VetSpecialty::getSpecialty)
                .map(Specialty::getSpecialtiesNames)
                .collect(Collectors.toSet());
    }

    /**
     * vet 삭제 메소드
     * vet Id를 통해 삭제.
     * */
    @Transactional
    public void deleteVet(Long vetId){
        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        vetRepository.delete(vet);
    }

    /**
     * 학위 추가 메소드
     * */
    @Transactional
    public void addSpecialties(Long vetId,
                                  VetReqDto.ADD_DELETE add){

        Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final List<VetSpecialty> vetSpecialties = getOrCreateVetSpecialties(add.getSpecialtiesName(), vet);

        vet.updateVetSpecialties(vetSpecialties);
    }

    /**
     * 학위 삭제 메소드
     * vetId를 통해 vet 찾은 후 specialtiesName을 연관관계 테이블 -> 저장소를 통해 가져온 후 삭제한다.
     * */
    @Transactional
    public void deleteSpecialties(Long vetId,
                                  VetReqDto.ADD_DELETE delete){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final Set<VetSpecialty> vetSpecialties = vetSpecialtiesRepository
                .findByVetAndSpecialty_SpecialtiesNamesIn(vet, delete.getSpecialtiesName());

        vetSpecialtiesRepository.deleteAll(vetSpecialties);

        deleteBySpecialtiesWithoutVet(delete.getSpecialtiesName());


    }

    /**
     * 연관관계 테이블을 이용해 Specialties name 추출
     * */
    private List<String> getSpecialtiesNameByVet(Vet vet){

        return vet.getVetSpecialties()
                .stream()
                .map(VetSpecialty::getSpecialty)
                .map(Specialty::getSpecialtiesNames)
                .collect(Collectors.toList());
    }

    /**
     * CreateVetService 필요하다
     * 학위가 존재하면 가져오고, 존재하지 않으면 생성한다.
     * */
    private Set<Specialty> getOrCreateSpecialtiesByNames(Set<String> specialtiesNames) {

        List<Specialty> specialties = specialtyRepository.findAllBySpecialtiesNameIn(specialtiesNames);

        final Set<String> existNames = specialties
                .stream()
                .map(Specialty::getSpecialtiesNames)
                .collect(Collectors.toSet());

        final List<Specialty> createSpecialties = specialtiesNames
                .stream()
                .filter(name -> !existNames.contains(name))
                .map(specialtiesMapper::toSpecialtyEntity)
                .collect(Collectors.toList());

        specialtyRepository.saveAll(createSpecialties);

        specialties.addAll(createSpecialties);

        return new HashSet<>(specialties);
    }

    private List<VetSpecialty> getOrCreateVetSpecialties(Set<String> specialtiesName,
                                                        Vet vet){

        final Set<Specialty> specialties = getOrCreateSpecialtiesByNames(specialtiesName);

        return specialties.stream()
                .map(specialty -> vetSpecialtiesMapper.toVetSpecialtiesEntity(specialty, vet))
                .collect(Collectors.toList());
    }

    private void deleteBySpecialtiesWithoutVet(Set<String> specialtiesNames){

        specialtiesNames.stream()
                .filter(specialtyName -> vetSpecialtiesRepository.countBySpecialtyName(specialtyName) == 0)
                .map(specialtyName -> specialtyRepository.findBySpecialtyName(specialtyName)
                        .orElseThrow(() -> new SpecialtiesNotFoundException(ErrorCodeType.FAIL_NOT_SPECIALTY_FOUND)))
                .forEach(specialtyRepository::delete);
    }
}
