package kr.co.pcmpetclinicstudy.controller.infra.error.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCodeType {

    //Success
    SUCCESS_OK("요청이 성공적으로 처리되었습니다.", HttpStatus.OK),
    SUCCESS_CREATE("요청이 성공적으로 처리되었으며 새로운 리소스가 생성되었습니다.", HttpStatus.CREATED),
    SUCCESS_ACCEPTED("요청이 성공적으로 처리되었지만, 결과는 아직 완료되지 않았습니다..", HttpStatus.ACCEPTED),
    SUCCESS_NO_VALUE("요청이 성공적으로 처리되었지만, 응답 데이터가 없습니다..", HttpStatus.NO_CONTENT),

    //Fail
    FAIL_BAD_REQUEST("클라이언트의 요청이 잘못되었습니다.", HttpStatus.BAD_REQUEST),
    FAIL_UNAUTHORIZED("클라이언트가 인증되지 않았습니다..", HttpStatus.UNAUTHORIZED),
    FAIL_FORBIDDEN("클라이언트가 요청한 리소스에 접근할 권한이 없습니다.", HttpStatus.FORBIDDEN),

    //FailNotFound 404 error
    FAIL_NOT_OWNER_FOUND("OWNER를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    FAIL_NOT_PET_FOUND("PET을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    FAIL_NOT_VISIT_FOUND("VISIT을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    FAIL_NOT_VET_FOUND("VET을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);


    private String message;

    private HttpStatus statusCode;
}
