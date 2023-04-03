package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.CreateVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.DeleteVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.UpdateVetDto;
import kr.co.pcmpetclinicstudy.service.service.VetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vet")
public class VetsController {

    private final VetsService vetsService;

    @PostMapping
    public void createVet(@Valid CreateVetDto createVetDto){
        vetsService.CreateVet(createVetDto);
    }

    @PutMapping
    public void updateVet(@Valid UpdateVetDto updateVetDto){
        vetsService.updateVet(updateVetDto);
    }

    @DeleteMapping
    public void deleteVet(DeleteVetDto deleteVetDto){
        vetsService.deleteVet(deleteVetDto);
    }
}
