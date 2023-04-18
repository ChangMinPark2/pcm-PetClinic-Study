package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.infra.error.exception.OwnerNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.PetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.VisitNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.Vet;
import kr.co.pcmpetclinicstudy.persistence.entity.Visit;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.PetRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VetRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VisitRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.VisitMapper;
import kr.co.pcmpetclinicstudy.service.model.request.VisitReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VisitResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VisitService {

    private final VisitRepository visitRepository;

    private final PetRepository petRepository;

    private final VisitMapper visitMapper;

    private final VetRepository vetRepository;

    private final OwnerRepository ownerRepository;

    @Transactional
    public void createVisit(VisitReqDto.CREATE create){

        final Pet pet = petRepository.findById(create.getPetId())
                .orElseThrow(() -> new PetNotFoundException(ErrorCodeType.FAIL_NOT_PET_FOUND));

        final Owner owner = ownerRepository.findById(create.getOwnerId())
                .orElseThrow(() -> new PetNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));

        final Vet vet = vetRepository.findById(create.getVetId())
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        final Visit visit = visitMapper.toVisitEntity(create, pet, owner, vet);

        visitRepository.save(visit);
    }

    public void deleteVisit(Long visitId){
        final Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new VisitNotFoundException(ErrorCodeType.FAIL_NOT_VISIT_FOUND));

        visitRepository.delete(visit);
    }

    /**
     * 해당 소유자 방문 정보 리스트 출력
     * ownerId 찾은 후 owner가 가진 방문정보 리스트를 출력한다.
     * */
    public List<VisitResDto.READ> readOwnerToVisit(Long ownerId){

        final Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));

        return visitRepository.findByOwnerId(owner.getId())
                .stream()
                .map(visitMapper::toReadDto)
                .collect(Collectors.toList());
    }

    /**
     * 해당 수의사가 방문자 정보 리스트 출력
     * vetId 찾은 후 visit이 가진 방문정보 리스트를 출력한다.
     * */
    public List<VisitResDto.READ> readVetToVisit(Long vetId){

        final Vet vet = vetRepository.findById(vetId)
                .orElseThrow(() -> new VetNotFoundException(ErrorCodeType.FAIL_NOT_VET_FOUND));

        return visitRepository.findByVetId(vet.getId())
                .stream()
                .map(visitMapper::toReadDto)
                .collect(Collectors.toList());
    }

    /**
     * 해당 애완동물 방문 정보 리스트 출력
     * petId 찾은 후 pet이 가진 방문정보 리스트를 출력한다.
     * */
    public List<VisitResDto.READ> readPetToVisit(Long petId){

        final Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new PetNotFoundException(ErrorCodeType.FAIL_NOT_PET_FOUND));

        return visitRepository.findByPetId(pet.getId())
                .stream()
                .map(visitMapper::toReadDto)
                .collect(Collectors.toList());
    }

    /**
     *  방문정보 id를 통해 상세한 방문정보를 출력한다.
     * */
    public VisitResDto.READ_DETAIL readDetailVisit(Long visitId){
        final Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new VisitNotFoundException(ErrorCodeType.FAIL_NOT_VISIT_FOUND));

        return visitMapper.toReadDetailDto(visit);
    }
}
