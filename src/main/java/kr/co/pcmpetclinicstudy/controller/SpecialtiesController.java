package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.infra.error.model.ResponseFormat;
import kr.co.pcmpetclinicstudy.service.model.request.SpecialtiesReqDto;
import kr.co.pcmpetclinicstudy.service.service.SpecialtiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
