package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.ReadPetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.UpdatePetDto;
import kr.co.pcmpetclinicstudy.service.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void deletePet(@PathVariable (name = "pet_id") Long petId){
        petsService.deletePetById(petId);
    }

    @GetMapping
    public List<ReadPetDto> readPet(@PathVariable(name = "owner_id") Long ownerId){
      return petsService.readPet(ownerId);
    }
}
