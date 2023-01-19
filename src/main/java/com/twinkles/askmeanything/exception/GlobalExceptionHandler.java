package com.twinkles.askmeanything.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AskMeAnyThingException.class)
    public ResponseEntity<?> handleAskMeAnythingException(AskMeAnyThingException askMeAnyThingException){
        ApiResponse apiResponse = new ApiResponse(false, askMeAnyThingException.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
