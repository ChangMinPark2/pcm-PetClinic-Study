package kr.co.pcmpetclinicstudy.controller.infra.error.exception;

import kr.co.pcmpetclinicstudy.controller.infra.error.model.ErrorCodeType;
/**
 * 인증된 사용자가 권한이 없는 리소스에 엑세스하려고 할 때 발생된다.
 * */
public class ForbiddenException extends BusinessException{

    public ForbiddenException(ErrorCodeType errorCodeType){
        super(errorCodeType);
    }

    public ForbiddenException(String message){
        super(message);
    }
}
