package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.CreateOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.ReadOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.UpdateOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OwnersService {

    private final OwnerRepository ownerRepository;

    @Transactional
    public void createOwner(CreateOwnerDto createOwnerDto){

        final Owner ownerBuild = Owner.createOf(createOwnerDto);

        ownerRepository.save(ownerBuild);
    }

    @Transactional
    public void updateOwner(UpdateOwnerDto updateOwnerDto){

        Owner owner = ownerRepository.findById(updateOwnerDto.getId())
                        .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        owner.updateOwner(updateOwnerDto);

        ownerRepository.save(owner);
    }

    public void deleteOwner(Long ownerId){

        final Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        ownerRepository.delete(owner);
    }

    @Transactional(readOnly = true)
    public ReadOwnerDto readOwner(Long ownerId){
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        return owner.readOf(owner);
    }
}
