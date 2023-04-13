package kr.co.pcmpetclinicstudy.infra.error.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;

/**
 * Http 요청에 대한 응답을 담당하는 클래스.
 * isSuccessful -> Http 요청이 성공적으로 처리됬는지 -> boolean
 * data -> Http 요청에 대한 결과 데이터를 포함하는 Optional 객체, 없으면 Optional.empty();
 * message -> Http 요청 처리 결과 메시지. (errorCode enum에 정의해둔 메시지.)
 * httpStatus -> Http 요청에 대한 처리 결과 상태코드.
 * */
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResponseFormat<T> {

    private boolean isSuccessful;

    private Optional<T> data;

    private String message;

    private HttpStatus httpStatus;

    /**
     * success
     * data -> x
     * message, Httpstatus -> ErrorcodeType
     * */
    public static <T> ResponseFormat<T> success(ErrorCodeType errorCode){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.empty())
                .message(errorCode.getMessage())
                .httpStatus(errorCode.getStatusCode())
                .build();
    }

    /**
     * success
     * data -> o
     * message, Httpstatus -> ErrorcodeType
     * */
    public static <T> ResponseFormat<T> successWithData(ErrorCodeType errorCode,
                                                        T data){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.ofNullable(data))
                .message(errorCode.getMessage())
                .httpStatus(errorCode.getStatusCode())
                .build();
    }

    /**
     * fail
     * data -> x
     * message, Httpstatus -> ErrorcodeType
     * */
    public static <T> ResponseFormat<T> error(ErrorCodeType errorCode){

        return ResponseFormat.<T>builder()
                .isSuccessful(false)
                .data(Optional.empty())
                .message(errorCode.getMessage())
                .httpStatus(errorCode.getStatusCode())
                .build();
    }
}
