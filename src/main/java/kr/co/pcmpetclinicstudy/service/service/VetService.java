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

        Vet vet = vetMapper.toVetEntity(create, Collections.emptyList());

        final List<VetSpecialties> vetSpecialties = getOrCreateVetSpecialties(create.getSpecialtiesName(), vet);

        vet.updateVetSpecialties(vetSpecialties);

        vetRepository.save(vet);
    }

    public VetResDto.READ readVetDto(Long vetId){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final List<String> specialtiesName = getSpecialtiesNameByVet(vet);

        return vetMapper.toReadDto(vet, specialtiesName);
    }

    @Transactional
    public void updateVet(VetReqDto.UPDATE update){

        Vet vet = vetRepository.findById(update.getVetId())
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final List<VetSpecialties> vetSpecialties = getOrCreateVetSpecialties(update.getSpecialtiesName(), vet);

        vet.updateVetSpecialties(vetSpecialties);
    }

    public void deleteVet(Long vetId){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        vetRepository.delete(vet);
    }

    private List<String> getSpecialtiesNameByVet(Vet vet){

        return vet.getVetSpecialties().stream() //-> vetSpecialties를 스트림으로 변환,(각 분야 별로 순환 가능)
                .map(VetSpecialties::getSpecialties)  //-> VetSpecialties를 Specialties로 변환
                .map(Specialties::getSpecialtiesName) //-> Specialties의 이름만 추출.
                .collect(Collectors.toList()); //-> collect를 통해 리스트로 변환.
    }

    /**
     * Specialties 이름 리스트를 이용해, 해당 이름으로 검색한 전문 분야 객체 리스트를 가져옴
     * 새로운 이름이 있으면 -> 새로운 전문 분야 객체를 생성하여 반환함
     * */
    private List<Specialties> getOrCreateSpecialtiesByNames(List<String> names){

        List<Specialties> specialties = specialtiesRepository.findAllByName(names);

        final Set<String> existNames = specialties.stream()//speciallties -> 스트림으로 변환
                .map(Specialties::getSpecialtiesName) //-> 전문 분야 객체의 이름을 추출
                .collect(Collectors.toSet()); //중복되지 않은 전문 분야 이름의 set 컬렉션 생성

        final List<Specialties> createSpecialties = names.stream()
                .filter(name -> !existNames.contains(name))// existNames Set 컬렉션에 포함되지 않는 이름만 추출
                .map(specialtiesMapper::toSpecialtiesEntity) // 해당 이름으로 새로운 전문분야 객체 생성
                .collect(Collectors.toList());  // 새로운 전문분야 객체 -> createSpecialties 리스트에 저장

        specialties.addAll(createSpecialties); // 리스트에 새로 생성한 전문 분야 객체 리스트를 추가.

        return specialties;
    }

    /**
     * 학위이름 리스트와, Vet 객체를 이용해 해당 이름으로 검색한 전문 분야 객체를 가져온다.
     * 새로운 전문 분야 객체를 생성한 후 Vet 객체와 연결한 VetSpecialties 객체 리스트를 반환한다.
     * */
    private List<VetSpecialties> getOrCreateVetSpecialties(List<String> names,
                                                           Vet vet){

        //입력받은 이름 리스트를 이용하여, 검색한 번문 분야 객체 리스트를 가져온다.
        //가져온 전문 분야 객체 리스트를 specialties 리스트에 저장한다.
        final List<Specialties> specialty = getOrCreateSpecialtiesByNames(names);

        //입력받은 이름 리스트를 이용하여, 검색한 번문 분야 객체 리스트를 가져온다.
        //가져온 전문 분야 객체 리스트를 specialties 리스트에 저장한다.
        //map -> 각 전문 분야 객체에 대응되는 VetSpecialties를 생성
        //Mapper -> 해당 전문 분야 객체와 Vet 객체를 이용하여 새로운 VetSpecialties객체를 생성
        return specialty.stream()
                .map(specialties -> vetSpecialtiesMapper.toVetSpecialtiesEntity(specialties, vet))
                .collect(Collectors.toList());
    }

}
