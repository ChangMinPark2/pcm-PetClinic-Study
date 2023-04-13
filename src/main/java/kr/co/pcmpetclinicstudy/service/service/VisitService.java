package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.infra.error.exception.PetNotFoundException;
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

        final Vet vet = vetRepository.findById(create.getPetId())
                .orElseThrow(() -> new PetNotFoundException(ErrorCodeType.FAIL_NOT_PET_FOUND));

        final Owner owner = ownerRepository.findById(create.getPetId())
                .orElseThrow(() -> new PetNotFoundException(ErrorCodeType.FAIL_NOT_PET_FOUND));

        final Visit visit = visitMapper.toVisitEntity(create, pet, vet, owner);

        visitRepository.save(visit);
    }

    @Transactional
    public void deleteVisit(Long visitId){
        final Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new VisitNotFoundException(ErrorCodeType.FAIL_NOT_VISIT_FOUND));

        visitRepository.delete(visit);
    }

    public List<VisitResDto.READ> readVet(Long petId){

        final Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new PetNotFoundException(ErrorCodeType.FAIL_NOT_PET_FOUND));

        final List<Visit> visit = visitRepository.findByPet(pet);

        return visit.stream()
                .map(visitMapper::toReadDto)
                .collect(Collectors.toList());
    }
}
