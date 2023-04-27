package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.infra.error.exception.OwnerNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.infra.error.model.ResponseFormat;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.OwnerResDto;
import kr.co.pcmpetclinicstudy.service.service.OwnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/owners")
public class OwnerController {

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

    /**
     * ResponseFormat? -> 제네릭 선언, 어떤 타입이든 사용될 수 있다는 것을 의미한다.
     * */
    @GetMapping
    private ResponseFormat<?> readOwner(OwnerReqDto.CONDITION condition){
        try {
            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, ownersService.readOwner(condition));
        } catch (RuntimeException e){
            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
        }
    }

//    @GetMapping("/{owners_id}")
//    public ResponseFormat<OwnerResDto.READ> readOwner(@PathVariable(name = "owners_id") Long ownerId){
//        try {
//            return ResponseFormat.successWithData(ErrorCodeType.SUCCESS_OK, ownersService.readOwner(ownerId));
//        } catch (OwnerNotFoundException e){
//            return ResponseFormat.error(ErrorCodeType.FAIL_NOT_OWNER_FOUND);
//        } catch (RuntimeException e){
//            return ResponseFormat.error(ErrorCodeType.FAIL_BAD_REQUEST);
//        }
//    }

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

    @DeleteMapping("/{owners_id}")
    public ResponseFormat<Void> deleteOwner(@PathVariable(name = "owners_id")Long ownerId){
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
