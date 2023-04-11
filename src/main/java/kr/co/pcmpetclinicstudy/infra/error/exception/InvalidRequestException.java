package kr.co.pcmpetclinicstudy.infra.error.exception;

import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;

/**
 * 사용자(클라이언트)의 잘못으로 요청이 왔을 때
 * */
public class InvalidRequestException extends BusinessException{

    public InvalidRequestException(ErrorCodeType errorCodeType){
        super(errorCodeType);
    }

    public InvalidRequestException(String message){
        super(message);
    }
}
