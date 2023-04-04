package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.CreateVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.DeleteVisitDto;
import kr.co.pcmpetclinicstudy.service.model.request.visitDto.ReadVisitDto;
import kr.co.pcmpetclinicstudy.service.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/visit")
public class VisitController {

    private final VisitService visitsService;

    @PostMapping
    public void createVisit(@RequestBody @Valid CreateVisitDto createVisitDto){
        visitsService.createVisit(createVisitDto);
    }

    @DeleteMapping
    public void deleteVisit(@RequestBody @Valid DeleteVisitDto deleteVisitDto){
        visitsService.deleteVisit(deleteVisitDto);
    }

    @GetMapping
    public ReadVisitDto readVisit(@RequestParam("id") Long id){
        return visitsService.readVet(id);
    }
}
