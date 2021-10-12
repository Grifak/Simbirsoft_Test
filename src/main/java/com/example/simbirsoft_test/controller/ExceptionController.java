package com.example.simbirsoft_test.controller;

import com.example.simbirsoft_test.exception.ApiError;
import com.example.simbirsoft_test.exception.HtmlReaderIOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(HtmlReaderIOException.class)
    public ResponseEntity<ApiError> handleHtmlReaderEx(HtmlReaderIOException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError.builder()
                .debugMessage(e.getMessage())
                .timestamp(Timestamp.from(Instant.now()))
                .status(status)
                .build();

        return new ResponseEntity<>(apiError, status);
    }

}
