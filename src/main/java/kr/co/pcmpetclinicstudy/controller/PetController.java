package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.DeletePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.ReadPetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.UpdatePetDto;
import kr.co.pcmpetclinicstudy.service.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pets")
public class PetController {

    private final PetService petsService;

    @PostMapping
    public void createPet(@RequestBody @Valid CreatePetDto createPetDto){
        petsService.createPet(createPetDto);
    }

    @PutMapping
    public void updatePet(@RequestBody @Valid UpdatePetDto updatePetDto){
        petsService.updatePet(updatePetDto);
    }

    @DeleteMapping
    public void deletePet(@RequestBody @Valid DeletePetDto deletePetDto){
        petsService.deletePet(deletePetDto);
    }

    @GetMapping
    public ReadPetDto readPet(@RequestParam("id") Long id){
      return petsService.readPet(id);
    }
}
