package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Owners;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnersRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.PetRepository;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.DeletePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.ReadPetDto;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.UpdatePetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    private final OwnersRepository ownersRepository;

    public void createPet(CreatePetDto createPetDto){

        final Owners owners = ownersRepository.findById(createPetDto.getId())
                .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        final Pet petBuild = Pet.of(createPetDto);

        petRepository.save(petBuild);
    }

    public void updatePet(UpdatePetDto updatePetDto){

        Pet pet = petRepository.findById(updatePetDto.getId())
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        pet.updatePet(updatePetDto.getBirthDate(), updatePetDto.getName(),
                updatePetDto.getOwners(), updatePetDto.getPetsTypes());

        petRepository.save(pet);
    }

    public void deletePet(DeletePetDto deletePetDto){

        final Pet pet = petRepository.findById(deletePetDto.getId())
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        petRepository.delete(pet);
    }

    @Transactional(readOnly = true)
    public ReadPetDto readPet(Long id){
        Pet pets = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        return pets.of(pets);
    }
}
