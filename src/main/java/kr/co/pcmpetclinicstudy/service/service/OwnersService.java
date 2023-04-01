package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Owners;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnersRepository;
import kr.co.pcmpetclinicstudy.service.model.request.CreateOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.DeleteOwnerDto;
import kr.co.pcmpetclinicstudy.service.model.request.UpdateOwnerDto;
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
}
