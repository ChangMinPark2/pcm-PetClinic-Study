package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
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
    public void createOwner(@RequestBody @Valid OwnerReqDto.CREATE create){
        ownersService.createOwner(create);
    }

    @PutMapping
    public void updateOwner(@RequestBody @Valid OwnerReqDto.UPDATE update){
        ownersService.updateOwner(update);
    }

    @DeleteMapping("/{owner_id}")
    public void deleteOwner(@PathVariable(name = "owner_id")Long ownerId){
        ownersService.deleteOwner(ownerId);
    }

    @GetMapping("/{owner_id}")
    public OwnerResDto.READ readOwner(@PathVariable(name = "owner_id") Long ownerId){
        return ownersService.readOwner(ownerId);
    }
}
