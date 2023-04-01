package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.service.model.request.CreateOwnerDto;
import kr.co.pcmpetclinicstudy.service.service.OwnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OwnersController {

    private final OwnersService ownersService;

    @PostMapping
    public void createOwner(@RequestBody CreateOwnerDto createOwnerDto){
        ownersService.createOwner(createOwnerDto);
    }
}
