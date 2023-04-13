package kr.co.pcmpetclinicstudy.owner;

import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.persistence.repository.OwnerRepository;
import kr.co.pcmpetclinicstudy.service.model.mapper.OwnerMapper;
import kr.co.pcmpetclinicstudy.service.model.request.OwnerReqDto;
import kr.co.pcmpetclinicstudy.service.service.OwnersService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceExceptionUnitTest {

    private OwnersService ownerService;

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private OwnerMapper ownerMapper;

    @Test
    @DisplayName("입력 값이 없을 때 -> NullPointerException")
    public void createOwner_NullPointerException() {

        //given
        final OwnerReqDto.CREATE create = OwnerReqDto.CREATE.builder().build();

        //when, then
        assertThrows(NullPointerException.class, () -> ownerService.createOwner(create));
    }
    
    


}
