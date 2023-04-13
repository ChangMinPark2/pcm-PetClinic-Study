package kr.co.pcmpetclinicstudy.infra.error.exception;

import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;

/**
 * 요청한 리소스가 존재하지 않을 때 발생하는 예외이다. (Pet)
 * */
public class PetNotFoundException extends BusinessException{

    public PetNotFoundException(ErrorCodeType errorCodeType){
        super(errorCodeType);
    }

    public PetNotFoundException(String message){
        super(message);
    }
}
