package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.PetRepository;
import kr.co.pcmpetclinicstudy.service.model.PetsTypes;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.DeletePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.ReadPetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.UpdatePetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    private final OwnerRepository ownersRepository;

    public void createPet(CreatePetDto createPetDto){

        final Owner owners = ownersRepository.findById(createPetDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        final Pet petBuild = Pet.of(createPetDto, owners);

        petRepository.save(petBuild);
    }

    public void updatePet(UpdatePetDto updatePetDto){

        Pet pet = petRepository.findById(updatePetDto.getPetId())
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        pet.updatePet(updatePetDto.getBirthDate(), updatePetDto.getName(), updatePetDto.getPetsTypes());

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
