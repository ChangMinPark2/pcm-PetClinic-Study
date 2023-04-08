package kr.co.pcmpetclinicstudy.service.model.exception;

import kr.co.pcmpetclinicstudy.service.model.ErrorCode;

public class OwnerIdDuplicatedException extends BusinessException{
    public OwnerIdDuplicatedException(){super(ErrorCode.OWNER_DUPLICATED);}
}
