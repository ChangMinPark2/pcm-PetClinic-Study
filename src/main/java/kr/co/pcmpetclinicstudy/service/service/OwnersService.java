package kr.co.pcmpetclinicstudy.service.service;

import kr.co.pcmpetclinicstudy.infra.error.exception.DuplicatedException;
import kr.co.pcmpetclinicstudy.infra.error.exception.OwnerNotFoundException;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.entity.Owner;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.persistence.repository.search.OwnerSearchRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.OwnerMapper;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import kr.co.pcmpetclinicstudy.service.model.response.OwnerResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OwnersService {

    private final OwnerRepository ownerRepository;

    private final OwnerSearchRepository ownerSearchRepository;

    private final OwnerMapper ownerMapper;

    @Transactional
    public void createOwner(OwnerReqDto.CREATE create){

        final Owner owner = ownerMapper.toOwnerEntity(create);

        checkTelephone(owner.getTelephone());

        ownerRepository.save(owner);
    }

    @Transactional
    public void updateOwner(OwnerReqDto.UPDATE update){

        Owner owner = ownerRepository.findById(update.getOwnerId())
                        .orElseThrow(() -> new OwnerNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));

        owner.updateOwner(update);

        ownerRepository.save(owner);
    }

    @Transactional
    public void deleteOwner(Long ownerId){

        final Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new OwnerNotFoundException(ErrorCodeType.FAIL_NOT_OWNER_FOUND));

        ownerRepository.delete(owner);
    }

    public List<OwnerResDto.READ> readOwner(OwnerReqDto.CONDITION condition){
        List<Owner> owner = ownerSearchRepository.find(condition);
//
//        return ownerMapper.toReadDto(owner);

        return owner
                .stream()
                .map(ownerMapper::toReadDto)
                .collect(Collectors.toList());

    }

    private void checkTelephone(String telephone){
        if (ownerRepository.existsByTelephone(telephone)){
            throw new DuplicatedException(ErrorCodeType.FAIL_DUPLICATED_PHONENUMBER);
        }
    }
}
