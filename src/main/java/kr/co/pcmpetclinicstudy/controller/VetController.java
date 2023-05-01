package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.infra.error.exception.SpecialtiesNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.infra.error.model.ResponseFormat;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VetResDto;
import kr.co.pcmpetclinicstudy.service.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vets")
public class VetController {

    private final VetService vetsService;

    @PostMapping
    public ResponseFormat<Void> createVet(@RequestBody @Valid VetReqDto.CREATE create){
        try {
            vetsService.createVet(create);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_CREATE);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @GetMapping("/{vets_id}")
    public ResponseFormat<VetResDto.READ> readVet(@PathVariable(name = "vets_id") Long vetId){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, vetsService.readVetDto(vetId));
        } catch (VetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VET_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @GetMapping("/specialties")
    public ResponseFormat<Set<String>> getVetSpecialties(){
        try{
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, vetsService.getVetSpecialties());
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @PutMapping("/specialties/{vets_id}")
    public ResponseFormat<Void> addSpecialties(@PathVariable(name = "vets_id") Long vetId,
                                               @RequestBody VetReqDto.ADD_DELETE add){
        try {
            vetsService.addSpecialties(vetId, add);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (VetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VET_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @DeleteMapping("/specialties/{vets_id}")
    public ResponseFormat<Void> deleteSpecialties(@PathVariable(name = "vets_id") Long vetId,
                                                  @RequestBody VetReqDto.ADD_DELETE delete){
        try {
            vetsService.deleteSpecialties(vetId, delete);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (SpecialtiesNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_SPECIALTY_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @DeleteMapping("/{vets_id}")
    public ResponseFormat<Void> deleteVet(@PathVariable(name = "vets_id")Long vetId){
        try {
            vetsService.deleteVet(vetId);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (VetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VET_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

}
