package kr.co.pcmpetclinicstudy.infra.error.exception;

import kr.co.pcmpetclinicstudy.service.model.enums.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private ErrorCode errorCode;

    public BusinessException (ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
