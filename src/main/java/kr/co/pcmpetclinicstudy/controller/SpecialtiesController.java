package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.infra.error.model.ResponseFormat;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.SpecialtiesResDto;
import kr.co.pcmpetclinicstudy.service.service.SpecialtiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/specialties")
@RequiredArgsConstructor
public class SpecialtiesController {

    private final SpecialtiesService specialtiesService;

    @PostMapping
    public ResponseFormat<Void> createSpecialties(@RequestBody SpecialtiesReqDto.CREATE create){
        try {
            specialtiesService.createSpecialties(create);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (VetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VET_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseFormat<List<SpecialtiesResDto.READ>> readAllSpecialties(){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, specialtiesService.readAllSpecialties());
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @GetMapping("{vets_id}")
    public ResponseFormat<List<SpecialtiesResDto.READ>> readVetOfSpecialties(@PathVariable("vets_id")Long vetId){
        try {
            specialtiesService.readSpecialtiesToId(vetId);
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, specialtiesService.readSpecialtiesToId(vetId));
        } catch (VetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VET_FOUND);
        }
    }
}
