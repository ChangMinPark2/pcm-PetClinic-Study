package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.persistence.entity.Owners;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnersRepository;
import kr.co.pcmpetclinicstudy.service.model.request.CreateOwnerDto;
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
}
