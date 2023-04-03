package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.CreateVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.DeleteVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.ReadVetDto;
import kr.co.pcmpetclinicstudy.service.model.request.vetDto.UpdateVetDto;
import kr.co.pcmpetclinicstudy.service.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vet")
public class VetController {

    private final VetService vetsService;

    @PostMapping
    public void createVet(@RequestBody @Valid CreateVetDto createVetDto){
        vetsService.CreateVet(createVetDto);
    }

    @PutMapping
    public void updateVet(@RequestBody @Valid UpdateVetDto updateVetDto){
        vetsService.updateVet(updateVetDto);
    }

    @DeleteMapping
    public void deleteVet(@RequestBody @Valid DeleteVetDto deleteVetDto){
        vetsService.deleteVet(deleteVetDto);
    }

    @GetMapping
    public ReadVetDto readVetDto(@RequestParam("id") Long id){
        return vetsService.readVetDto(id);
    }
}
