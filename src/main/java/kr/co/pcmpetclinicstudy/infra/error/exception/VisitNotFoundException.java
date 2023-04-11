package kr.co.pcmpetclinicstudy.infra.error.exception;

import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;

/**
 * 요청한 리소스가 존재하지 않을 때 발생하는 예외이다. (Visit)
 * */
public class VisitNotFoundException extends BusinessException{

    public VisitNotFoundException(ErrorCodeType errorCodeType){
        super(errorCodeType);
    }

    public VisitNotFoundException(String message){
        super(message);
    }
}
