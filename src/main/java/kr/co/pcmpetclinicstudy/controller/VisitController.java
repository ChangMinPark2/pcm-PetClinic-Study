package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.infra.error.exception.OwnerNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.PetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.VetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.VisitNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.infra.error.model.ResponseFormat;
import kr.co.pcmpetclinicstudy.service.model.request.VisitReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.VisitResDto;
import kr.co.pcmpetclinicstudy.service.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.Socket;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/visits")
public class VisitController {

    private final VisitService visitsService;

    @PostMapping
    public ResponseFormat<Void> createVisit(@RequestBody @Valid VisitReqDto.CREATE create){
        try{
            visitsService.createVisit(create);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_CREATE);
        } catch (PetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_PET_FOUND);
        } catch (OwnerNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_OWNER_FOUND);
        } catch (VetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VET_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @GetMapping("pets/{pets_id}")
    public ResponseFormat<List<VisitResDto.READ>> readPetToVisit(@PathVariable("pets_id") Long petId){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK,visitsService.readPetToVisit(petId));
        } catch (PetNotFoundException e) {
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_PET_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }

    }

    @GetMapping("vets/{vets_id}")
    public ResponseFormat<List<VisitResDto.READ>> readVetToVisit(@PathVariable("vets_id") Long vetId){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK,visitsService.readVetToVisit(vetId));
        } catch (VetNotFoundException e) {
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VET_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }

    }

    @GetMapping("owners/{owners_id}")
    public ResponseFormat<List<VisitResDto.READ>> readOwnerToVisit(@PathVariable("owners_id") Long ownerId){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, visitsService.readOwnerToVisit(ownerId));
        } catch (OwnerNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_OWNER_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @GetMapping("detail/{visits_id}")
    public ResponseFormat<VisitResDto.READ_DETAIL> readDetailVisit(@PathVariable("visits_id")Long visitId){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, visitsService.readDetailVisit(visitId));
        } catch (VisitNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VISIT_FOUND);
        }
    }

    @DeleteMapping("/{visits_id}")
    public ResponseFormat<Void> deleteVisit(@PathVariable(name = "visits_id") Long visitId){
        try {
            visitsService.deleteVisit(visitId);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (VisitNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_VISIT_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }
}
