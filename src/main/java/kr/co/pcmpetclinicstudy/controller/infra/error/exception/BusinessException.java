package kr.co.pcmpetclinicstudy.controller.infra.error.exception;

import kr.co.pcmpetclinicstudy.controller.infra.error.model.ErrorCodeType;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private ErrorCodeType errorCode;

    public BusinessException (ErrorCodeType errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.errorCode = errorCode;
    }

    public BusinessException(String message){
        super(message);
    }
}
