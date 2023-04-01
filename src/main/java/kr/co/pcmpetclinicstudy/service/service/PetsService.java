package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Pets;
import kr.co.pcmpetclinicstudy.persistence.repository.PetsRepository;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.DeletePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.ReadPetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.UpdatePetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetsService {

    private final PetsRepository petsRepository;

    public void createPet(CreatePetDto createPetDto){
        Pets pets = new Pets();
        petsRepository.save(pets);
    }

    public void UpdatePet(UpdatePetDto updatePetDto){
        Pets pets = new Pets();
        petsRepository.save(pets);
    }

    public void deletePet(DeletePetDto deletePetDto){
        Pets pets = new Pets();
        petsRepository.delete(pets);
    }

    public ReadPetDto readPet(String identity){
        Pets pets = new Pets();
        return pets.of(pets);
    }
}
