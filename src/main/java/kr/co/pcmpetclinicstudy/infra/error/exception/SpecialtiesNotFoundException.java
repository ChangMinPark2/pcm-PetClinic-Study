package kr.co.pcmpetclinicstudy.infra.error.exception;

import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;

public class SpecialtiesNotFoundException extends BusinessException{

    public SpecialtiesNotFoundException(ErrorCodeType errorCodeType){
        super(errorCodeType);
    }

    public SpecialtiesNotFoundException(String message){
        super(message);
    }
}
