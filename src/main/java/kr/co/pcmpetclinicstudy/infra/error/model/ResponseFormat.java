package kr.co.pcmpetclinicstudy.infra.error.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResponseFormat<T> {
    private boolean isSuccessful;

    private Optional<T> data;

    private String message;

    private HttpStatus httpStatus;

    public static <T> ResponseFormat<T> success(ErrorCodeType errorCode){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.empty())
                .message(errorCode.getMessage())
                .httpStatus(errorCode.getStatusCode())
                .build();
    }

    public static <T> ResponseFormat<T> success(String message,
                                                HttpStatus status){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.empty())
                .message(message)
                .httpStatus(status)
                .build();
    }

    public static <T> ResponseFormat<T> successWithData(ErrorCodeType errorCode,
                                                        T data){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.ofNullable(data))
                .message(errorCode.getMessage())
                .httpStatus(errorCode.getStatusCode())
                .build();
    }

    public static <T> ResponseFormat<T> successWithData(String message,
                                                        HttpStatus status,
                                                        T data){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.ofNullable(data))
                .message(message)
                .httpStatus(status)
                .build();
    }

    public static <T> ResponseFormat<T> error(ErrorCodeType errorCode){

        return ResponseFormat.<T>builder()
                .isSuccessful(false)
                .data(Optional.empty())
                .message(errorCode.getMessage())
                .httpStatus(errorCode.getStatusCode())
                .build();
    }

    public static <T> ResponseFormat<T> error(String message,
                                              HttpStatus status){

        return ResponseFormat.<T>builder()
                .isSuccessful(false)
                .data(Optional.empty())
                .message(message)
                .httpStatus(status)
                .build();
    }
}
