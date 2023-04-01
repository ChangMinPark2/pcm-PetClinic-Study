package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Owners;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnersRepository;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerDto.CreateOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerDto.DeleteOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerDto.ReadOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerDto.UpdateOwnerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnersService {

    private final OwnersRepository ownersRepository;

    public void createOwner(CreateOwnerDto createOwnerDto){
        Owners owners = new Owners();
        ownersRepository.save(owners);
    }

    public void updateOwner(UpdateOwnerDto updateOwnerDto){
        Owners owners = new Owners();
        ownersRepository.save(owners);
    }

    public void deleteOwner(DeleteOwnerDto deleteOwnerDto){
        Owners owners = new Owners();
        ownersRepository.delete(owners);
    }

    public ReadOwnerDto readOwner(String identity){
        Owners owners = new Owners();

        return owners.of(owners);
    }
}
