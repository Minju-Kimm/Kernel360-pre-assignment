package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.controller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice //해당 클래스는 restapi 사용하는 곳에 예외가 발생하는 걸 감지하게 된다
@Order(1)
public class RestApiExceptionHandler {

    @ExceptionHandler(value = { IndexOutOfBoundsException.class })
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ) {
        log.error("IndexOutOfBoundsException", e);
        return ResponseEntity.status(200).build(); //200 OK
    }

    @ExceptionHandler(value = { NoSuchElementException.class })
    public ResponseEntity<Api> noSuchElement(
            NoSuchElementException e
    ) {
        log.error("", e);

        Api<Object> response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
