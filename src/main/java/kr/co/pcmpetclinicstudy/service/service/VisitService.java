package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.Visit;
import kr.co.pcmpetclinicstudy.persistence.repository.PetRepository;
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

    @Transactional
    public void createVisit(VisitReqDto.CREATE create){

        final Pet pet = petRepository.findById(create.getPetId())
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        final Visit visit = visitMapper.createOf(create, pet);

        visitRepository.save(visit);
    }

    @Transactional
    public void deleteVisit(Long visitId){
        final Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new RuntimeException("Not Found Visit"));

        visitRepository.delete(visit);
    }

    public List<VisitResDto.READ> readVet(Long petId){

        final Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        final List<Visit> visit = visitRepository.findByPet(pet);

        return visit.stream()
                .map(visitMapper::readOf)
                .collect(Collectors.toList());
    }
}
