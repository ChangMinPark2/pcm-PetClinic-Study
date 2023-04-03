package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.CreateVetDto;
import kr.co.pcmpetclinicstudy.service.service.VetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vet")
public class VetsController {

    private final VetsService vetsService;

    @PostMapping
    public void createVet(@Valid CreateVetDto createVetDto){
        vetsService.CreateVet(createVetDto);
    }
}
