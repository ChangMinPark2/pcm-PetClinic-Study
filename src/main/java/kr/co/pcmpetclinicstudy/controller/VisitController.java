package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.VisitReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VisitResDto;
import kr.co.pcmpetclinicstudy.service.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/visits")
public class VisitController {

    private final VisitService visitsService;

    @PostMapping
    public void createVisit(@RequestBody @Valid VisitReqDto.CREATE create){
        visitsService.createVisit(create);
    }

    @DeleteMapping("/{visit_id}")
    public void deleteVisit(@PathVariable(name = "visit_id") Long visitId){
        visitsService.deleteVisit(visitId);
    }

    @GetMapping("/{pet_id}")
    public List<VisitResDto.READ> readVisit(@PathVariable("pet_id") Long petId){
        return visitsService.readVet(petId);
    }
}
