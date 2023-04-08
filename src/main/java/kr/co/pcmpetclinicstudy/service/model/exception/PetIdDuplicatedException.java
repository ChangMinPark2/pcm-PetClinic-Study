package kr.co.pcmpetclinicstudy.service.model.exception;

import kr.co.pcmpetclinicstudy.service.model.ErrorCode;

public class PetIdDuplicatedException extends BusinessException{
    public PetIdDuplicatedException(){super(ErrorCode.PET_DUPLICATED);}
}
