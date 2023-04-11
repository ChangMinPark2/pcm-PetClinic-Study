package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.infra.error.exception.OwnerNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.exception.PetNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.entity.Pet;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.PetRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.PetMapper;
import kr.co.pcmpetclinicstudy.service.model.request.PetReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.PetResDto;
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

    private final PetMapper petMapper;

    @Transactional
    public void createPet(PetReqDto.CREATE create){

        final Owner owner = ownersRepository.findById(create.getOwnerId())
                .orElseThrow(() -> new OwnerNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));

        final Pet pet = petMapper.toPetEntity(create, owner);

        petRepository.save(pet);
    }

    public List<PetResDto.READ> readPet (Long ownerId){
        final Owner owner = ownersRepository.findById(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));

        final List<Pet> pet = petRepository.findByOwner(owner);

        return pet.stream()
                .map(petMapper::toReadDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updatePet(PetReqDto.UPDATE update){

        Pet pet = petRepository.findById(update.getPetId())
                .orElseThrow(() -> new PetNotFoundException(ErrorCodeType.FAIL_NOT_PET_FOUND));

        pet.updatePet(update);

        petRepository.save(pet);
    }

    @Transactional
    public void deletePetById(Long petId){

        final Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new PetNotFoundException(ErrorCodeType.FAIL_NOT_PET_FOUND));

        petRepository.delete(pet);
    }

}
