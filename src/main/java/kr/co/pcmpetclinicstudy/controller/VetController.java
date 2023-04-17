package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.infra.error.model.ResponseFormat;
import kr.co.pcmpetclinicstudy.service.model.request.VetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VetResDto;
import kr.co.pcmpetclinicstudy.service.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

//    @PutMapping
//    public ResponseFormat<Void> updateVet(@RequestBody @Valid VetReqDto.UPDATE update){
//        try {
//            vetsService.updateVet(update);
//            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
//        } catch (VetNotFoundException e){
//            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VET_FOUND);
//        } catch (RuntimeException e){
//            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
//        }
//    }

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
