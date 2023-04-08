package kr.co.pcmpetclinicstudy.service.model.exception;

import kr.co.pcmpetclinicstudy.service.model.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private ErrorCode errorCode;

    public BusinessException (ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
