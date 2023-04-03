package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Visit;
import kr.co.pcmpetclinicstudy.persistence.repository.VisitRepository;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.ReadVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.CreateVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.DeleteVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.ReadVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.UpdateVisitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public void createVisit(CreateVisitDto createVisitDto){

        Visit visitBuild = Visit.builder()
                .visitDate(createVisitDto.getVisitDate())
                .description(createVisitDto.getDescription())
                .pets(createVisitDto.getPets())
                .build();

        visitRepository.save(visitBuild);
    }

    public void updateVisit(UpdateVisitDto updateVisitDto){

        Visit visit = visitRepository.findById(updateVisitDto.getId())
                .orElseThrow(() -> new RuntimeException("Not Found Visit"));

        visit.updateVisit(updateVisitDto.getDescription(),
                updateVisitDto.getVisitDate(),
                updateVisitDto.getPets());

        visitRepository.save(visit);
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
