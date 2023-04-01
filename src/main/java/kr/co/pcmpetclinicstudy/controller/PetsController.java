package kr.co.pcmpetclinicstudy.controller;

import kr.co.pcmpetclinicstudy.service.model.request.PetDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.DeletePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.UpdatePetDto;
import kr.co.pcmpetclinicstudy.service.service.PetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pets")
public class PetsController {

    private final PetsService petsService;

    @PostMapping("/create")
    public void createPet(CreatePetDto createPetDto){
        petsService.createPet(createPetDto);
    }

    @PutMapping("/update")
    public void updatePet(UpdatePetDto updatePetDto){
        petsService.UpdatePet(updatePetDto);
    }

    @DeleteMapping("/delete")
    public void deletePet(DeletePetDto deletePetDto){
        petsService.deletePet(deletePetDto);
    }
}
