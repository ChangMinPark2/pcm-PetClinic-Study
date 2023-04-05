package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.Visit;
import kr.co.pcmpetclinicstudy.persistence.repository.PetRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VisitRepository;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.CreateVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.ReadVisitDto;
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

    @Transactional
    public void createVisit(CreateVisitDto createVisitDto){

        final Pet pet = petRepository.findById(createVisitDto.getPetId())
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        final Visit visitBuild = Visit.createOf(createVisitDto, pet);

        visitRepository.save(visitBuild);
    }

    @Transactional
    public void deleteVisit(Long visitId){
        final Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new RuntimeException("Not Found Visit"));

        visitRepository.delete(visit);
    }

    public List<ReadVisitDto> readVet(Long petId){

        final Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        final List<Visit> visit = visitRepository.findByPet(pet);

        return visit.stream()
                .map(Visit::readOf)
                .collect(Collectors.toList());
    }
}
