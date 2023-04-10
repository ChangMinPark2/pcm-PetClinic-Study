package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.controller.infra.error.exception.OwnerNotFoundException;
import kr.co.pcmpetclinicstudy.controller.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.OwnerMapper;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.OwnerResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OwnersService {

    private final OwnerRepository ownerRepository;

    private final OwnerMapper ownerMapper;

    @Transactional
    public void createOwner(OwnerReqDto.CREATE create){

        final Owner owner = ownerMapper.toOwnerEntity(create);

        ownerRepository.save(owner);
    }

    @Transactional
    public void updateOwner(OwnerReqDto.UPDATE update){

        Owner owner = ownerRepository.findById(update.getId())
                        .orElseThrow(() -> new OwnerNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));
        owner.updateOwner(update);

        ownerRepository.save(owner);
    }

    public void deleteOwner(Long ownerId){

        final Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));

        ownerRepository.delete(owner);
    }

    @Transactional(readOnly = true)
    public OwnerResDto.READ readOwner(Long ownerId){
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));

        return ownerMapper.toReadDto(owner);
    }
}
