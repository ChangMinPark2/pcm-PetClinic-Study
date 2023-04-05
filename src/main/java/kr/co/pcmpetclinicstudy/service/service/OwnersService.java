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

        Owner owners = ownerRepository.findById(updateOwnerDto.getId())
                        .orElseThrow(() -> new RuntimeException("Not Found Owner"));

        owners.updateOwner(updateOwnerDto);

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

        return owners.readOf(owners);
    }
}
