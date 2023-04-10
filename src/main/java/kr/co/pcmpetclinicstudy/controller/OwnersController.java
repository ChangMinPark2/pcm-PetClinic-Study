package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.controller.infra.error.exception.OwnerNotFoundException;
import kr.co.pcmpetclinicstudy.controller.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.controller.infra.error.model.ResponseFormat;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.OwnerResDto;
import kr.co.pcmpetclinicstudy.service.service.OwnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/owners")
public class OwnersController {

    private final OwnersService ownersService;

    @PostMapping
    public ResponseFormat<Void> createOwner(@RequestBody @Valid OwnerReqDto.CREATE create){
        try {
            ownersService.createOwner(create);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @GetMapping("/{owner_id}")
    public ResponseFormat<OwnerResDto.READ> readOwner(@PathVariable(name = "owner_id") Long ownerId){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, ownersService.readOwner(ownerId));
        } catch (OwnerNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_OWNER_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseFormat<Void> updateOwner(@RequestBody @Valid OwnerReqDto.UPDATE update){
        try {
            ownersService.updateOwner(update);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (OwnerNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_OWNER_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

    @DeleteMapping("/{owner_id}")
    public ResponseFormat<Void> deleteOwner(@PathVariable(name = "owner_id")Long ownerId){
        try {
            ownersService.deleteOwner(ownerId);
            return ResponseFormat.success(ErrorCodeType.SUCCESS_OK);
        } catch (OwnerNotFoundException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_OWNER_FOUND);
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

}
