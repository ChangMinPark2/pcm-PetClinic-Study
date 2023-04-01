package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.service.model.request.CreateOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.UpdateOwnerDto;
import kr.co.pcmpetclinicstudy.service.service.OwnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/owners")
public class OwnersController {

    private final OwnersService ownersService;

    @PostMapping("/create")
    public void createOwner(@RequestBody CreateOwnerDto createOwnerDto){
        ownersService.createOwner(createOwnerDto);
    }

    @PutMapping("/update")
    public void updateOwner(@RequestBody UpdateOwnerDto updateOwnerDto){
        ownersService.updateOwner(updateOwnerDto);
    }




}
