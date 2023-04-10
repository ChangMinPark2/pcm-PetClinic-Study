package kr.co.pcmpetclinicstudy.controller.infra.error.exception;

import kr.co.pcmpetclinicstudy.controller.infra.error.model.ErrorCodeType;

/**
 * 요청한 리소스가 존재하지 않을 때 발생하는 예외이다. (Vet)
 * */
public class VetNotFoundException extends BusinessException{

    public VetNotFoundException(ErrorCodeType errorCodeType){
        super(errorCodeType);
    }

    public VetNotFoundException(String message){
        super(message);
    }
}
