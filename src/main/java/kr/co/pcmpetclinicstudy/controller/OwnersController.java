package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.CreateOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.ReadOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.UpdateOwnerDto;
import kr.co.pcmpetclinicstudy.service.service.OwnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/owners")
public class OwnersController {

    private final OwnersService ownersService;

    @PostMapping
    public void createOwner(@RequestBody @Valid CreateOwnerDto createOwnerDto){
        ownersService.createOwner(createOwnerDto);
    }

    @PutMapping
    public void updateOwner(@RequestBody @Valid UpdateOwnerDto updateOwnerDto){
        ownersService.updateOwner(updateOwnerDto);
    }

    @DeleteMapping
    public void deleteOwner(@PathVariable(name = "owner_id")Long ownerId){
        ownersService.deleteOwner(ownerId);
    }

    @GetMapping
    public ReadOwnerDto readOwner(@PathVariable(name = "owner_id") Long ownerId){
        return ownersService.readOwner(ownerId);
    }
}
