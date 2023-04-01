package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Pets;
import kr.co.pcmpetclinicstudy.persistence.repository.PetsRepository;
import kr.co.pcmpetclinicstudy.service.model.request.PetDto.CreatePetDto;
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
}
