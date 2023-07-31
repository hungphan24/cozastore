package com.hung.cozastore.exception;

import com.hung.cozastore.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalCustomException {

    @ExceptionHandler(userNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(401);
        response.setData(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(customException.class)
    public ResponseEntity<?> handleCustomException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(500);
        response.setData(e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
