package kr.co.pcmpetclinicstudy.controller;

import jakarta.validation.Valid;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.PetResDto;
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
    public void createPet(@RequestBody @Valid PetReqDto.CREATE create){
        petsService.createPet(create);
    }

    @PutMapping
    public void updatePet(@RequestBody @Valid PetReqDto.UPDATE update){
        petsService.updatePet(update);
    }

    @DeleteMapping("/{pet_id}")
    public void deletePet(@PathVariable (name = "pet_id") Long petId){
        petsService.deletePetById(petId);
    }

    @GetMapping("/{owner_id}")
    public List<PetResDto.READ> readPet(@PathVariable(name = "owner_id") Long ownerId){
      return petsService.readPet(ownerId);
    }
}
