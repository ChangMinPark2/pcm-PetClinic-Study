package kr.co.pcmpetclinicstudy.controller.infra.error.exception;

import kr.co.pcmpetclinicstudy.controller.infra.error.model.ErrorCodeType;
/**
 * 중복 예외 -> 이미 존재하는 리소스를 생성하려고 할 때
 * */
public class DuplicatedException extends BusinessException{

    public DuplicatedException(ErrorCodeType errorCodeType){
        super(errorCodeType);
    }

    public DuplicatedException(String message){
        super(message);
    }
}
