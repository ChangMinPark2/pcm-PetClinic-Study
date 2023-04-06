package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.PetRepository;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.CreatePetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.ReadPetDto;
import kr.co.pcmpetclinicstudy.service.model.request.petDto.UpdatePetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PetService {

    private final PetRepository petRepository;

    private final OwnerRepository ownersRepository;

    @Transactional
    public void createPet(CreatePetDto createPetDto){

        final Owner owners = ownersRepository.findById(createPetDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        final Pet petBuild = Pet.createOf(createPetDto, owners);

        petRepository.save(petBuild);
    }

    @Transactional
    public void updatePet(UpdatePetDto updatePetDto){

        Pet pet = petRepository.findById(updatePetDto.getPetId())
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        pet.updatePet(updatePetDto);

        petRepository.save(pet);
    }

    @Transactional
    public void deletePetById(Long petId){

        final Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Not Found Pet"));

        petRepository.delete(pet);
    }

    public List<ReadPetDto> readPet (Long ownerId){
        final Owner owner = ownersRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        final List<Pet> pet = petRepository.findByOwner(owner);

        return pet.stream()
                .map(Pet::readOf)
                .collect(Collectors.toList());
    }
}
