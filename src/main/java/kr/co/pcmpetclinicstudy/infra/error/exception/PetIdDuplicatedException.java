package kr.co.pcmpetclinicstudy.infra.error.exception;

import kr.co.pcmpetclinicstudy.service.model.enums.ErrorCode;

public class PetIdDuplicatedException extends BusinessException{
    public PetIdDuplicatedException(){super(ErrorCode.PET_DUPLICATED);}
}
