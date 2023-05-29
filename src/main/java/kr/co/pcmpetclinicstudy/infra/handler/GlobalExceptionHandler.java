package kr.co.pcmpetclinicstudy.infra.handler;

import kr.co.pcmpetclinicstudy.infra.error.exception.*;
import kr.co.pcmpetclinicstudy.infra.error.model.ErrorCodeType;
import kr.co.pcmpetclinicstudy.infra.error.model.ResponseFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//전역 예외 처리를 담당하는 클라스인 GlobalExceptionHandler를 정의한다.
public class GlobalExceptionHandler {
    /**
     * 중복 에러 핸들러
     * */
    @ExceptionHandler(DuplicatedException.class)// 중복 에러 핸들러 메서드 정의
    protected ResponseEntity<ResponseFormat> handleDuplicatedException(DuplicatedException e){
    //해당 클래스 내부에만 접근
        ResponseFormat responseFormat = ResponseFormat.builder()
                .message(e.getMessage())
                .httpStatus(ErrorCodeType.FAIL_BAD_REQUEST.getStatusCode())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseFormat);
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    protected ResponseEntity<ResponseFormat> handleNotFoundException(OwnerNotFoundException e){

        ResponseFormat responseFormat = ResponseFormat.builder()
                .message(e.getMessage())
                .httpStatus(ErrorCodeType.FAIL_NOT_OWNER_FOUND.getStatusCode())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFormat);
    }

    @ExceptionHandler(PetNotFoundException.class)
    protected ResponseEntity<ResponseFormat> handleNotFoundException(PetNotFoundException e){

        ResponseFormat responseFormat = ResponseFormat.builder()
                .message(e.getMessage())
                .httpStatus(ErrorCodeType.FAIL_NOT_PET_FOUND.getStatusCode())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFormat);
    }

    @ExceptionHandler(SpecialtiesNotFoundException.class)
    protected ResponseEntity<ResponseFormat> handleNotFoundException(SpecialtiesNotFoundException e){

        ResponseFormat responseFormat = ResponseFormat.builder()
                .message(e.getMessage())
                .httpStatus(ErrorCodeType.FAIL_NOT_SPECIALTY_FOUND.getStatusCode())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFormat);
    }

    @ExceptionHandler(VetNotFoundException.class)
    protected ResponseEntity<ResponseFormat> handleNotFoundException(VetNotFoundException e){

        ResponseFormat responseFormat = ResponseFormat.builder()
                .message(e.getMessage())
                .httpStatus(ErrorCodeType.FAIL_NOT_VET_FOUND.getStatusCode())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFormat);
    }

    @ExceptionHandler(VisitNotFoundException.class)
    protected ResponseEntity<ResponseFormat> handleNotFoundException(VisitNotFoundException e){

        ResponseFormat responseFormat = ResponseFormat.builder()
                .message(e.getMessage())
                .httpStatus(ErrorCodeType.FAIL_NOT_VISIT_FOUND.getStatusCode())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFormat);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ResponseFormat> handleRuntimeException(RuntimeException e){

        ResponseFormat responseFormat = ResponseFormat.builder()
                .message(e.getMessage())
                .httpStatus(ErrorCodeType.FAIL_BAD_REQUEST.getStatusCode())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseFormat);
    }



}
