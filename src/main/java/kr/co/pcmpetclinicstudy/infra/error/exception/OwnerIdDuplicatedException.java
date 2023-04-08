package kr.co.pcmpetclinicstudy.infra.error.exception;

import kr.co.pcmpetclinicstudy.service.model.enums.ErrorCode;

public class OwnerIdDuplicatedException extends BusinessException{
    public OwnerIdDuplicatedException(){super(ErrorCode.OWNER_DUPLICATED);}
}
