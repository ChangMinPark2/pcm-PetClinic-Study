package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.CreateOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.DeleteOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.ReadOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.ownerDto.UpdateOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OwnersService {

    private final OwnerRepository ownerRepository;

    public void createOwner(CreateOwnerDto createOwnerDto){

        final Owner ownerBuild = Owner.of(createOwnerDto);

        ownerRepository.save(ownerBuild);
    }

    public void updateOwner(UpdateOwnerDto updateOwnerDto){

        Owner owners = ownerRepository.findById(updateOwnerDto.getId())
                        .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        owners.updateOwner(updateOwnerDto.getAddress(),
                updateOwnerDto.getCity(),
                updateOwnerDto.getFirstName(),
                updateOwnerDto.getLastName(),
                updateOwnerDto.getTelephone());

        ownerRepository.save(owners);
    }

    public void deleteOwner(DeleteOwnerDto deleteOwnerDto){

        final Owner owners = ownerRepository.findById(deleteOwnerDto.getId())
                .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        ownerRepository.delete(owners);
    }

    @Transactional(readOnly = true)
    public ReadOwnerDto readOwner(Long id){
        Owner owners = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        return owners.of(owners);
    }
}
