package kr.co.pcmpetclinicstudy.infra.error.exception;

import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;

/**
 * 인증되지 않은 사용자가 보호된 리소스에 엑세스하려고 할 때 발생시키는 예외이다.
 */
public class UnauthorizedException extends BusinessException{

    public UnauthorizedException(ErrorCodeType errorCodeType){
        super(errorCodeType);
    }

    public UnauthorizedException(String message){
        super(message);
    }
}
