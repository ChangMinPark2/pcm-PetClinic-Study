package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.entity.Visit;
import kr.co.pcmpetclinicstudy.persistence.repository.PetRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.VisitRepository;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.CreateVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.DeleteVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.ReadVisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    private final PetRepository petRepository;

    public void createVisit(CreateVisitDto createVisitDto){

        final Pet pet = petRepository.findById(createVisitDto.getPetId())
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        final Visit visitBuild = Visit.of(createVisitDto, pet);

        visitRepository.save(visitBuild);
    }

    @Transactional(readOnly = true)
    public void deleteVisit(DeleteVisitDto deleteVisitDto){
        final Visit visit = visitRepository.findById(deleteVisitDto.getId())
                .orElseThrow(() -> new RuntimeException("Not Found Visit"));

        visitRepository.delete(visit);
    }

    public ReadVisitDto readVet(Long id){
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found Visit"));

        return visit.of(visit);
    }
}
