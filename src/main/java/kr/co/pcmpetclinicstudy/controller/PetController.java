package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.controller.infra.error.exception.OwnerNotFoundException;
import kr.co.pcmpetclinicstudy.controller.infra.error.exception.PetNotFoundException;
import kr.co.pcmpetclinicstudy.controller.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.controller.infra.error.model.ResponseFormat;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.PetResDto;
import kr.co.pcmpetclinicstudy.service.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pets")
public class PetController {

    private final PetService petsService;

    @PostMapping
    public ResponseFormat<Void> createPet(@RequestBody @Valid PetReqDto.CREATE create){
        try{
            petsService.createPet(create);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_CREATE);
        } catch (OwnerNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_OWNER_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @GetMapping("/{owners_id}")
    public ResponseFormat<List<PetResDto.READ>> readPet(@PathVariable(name = "owners_id") Long ownerId){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, petsService.readPet(ownerId));
        } catch (OwnerNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_OWNER_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseFormat<Void> updatePet(@RequestBody @Valid PetReqDto.UPDATE update){
        try {
            petsService.updatePet(update);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (PetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_PET_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @DeleteMapping("/{pets_id}")
    public ResponseFormat<Void> deletePet(@PathVariable (name = "pets_id") Long petId){
        try{
            petsService.deletePetById(petId);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (PetNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_PET_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

}
