package com.zallpy.userapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
    public class GenericHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ExceptionResponse handlerBadRequestException(MethodArgumentNotValidException exception) {
            Map<String, String> errors = new HashMap<>();
            exception.getBindingResult().getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ExceptionResponse.ExceptionResponseBuilder()
                    .name("InvalidRequestException")
                    .cause(errors)
                    .timestamp(LocalDateTime.now())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }

        @ExceptionHandler(Exception.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public ExceptionResponse handlerInternalServerException(Exception exception) {
            return new ExceptionResponse.ExceptionResponseBuilder()
                    .name("InternalErrorException")
                    .cause(exception.getMessage())
                    .timestamp(LocalDateTime.now())
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

        @ExceptionHandler(ApiException.class)
        public ResponseEntity<ExceptionResponse> handlerApiExceptionException(ApiException exception) {
            ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                    .name("userNotFoundException")
                    .cause(exception.getMessage())
                    .httpStatus(exception.getStatus())
                    .timestamp(LocalDateTime.now())
                    .build();
            return new ResponseEntity<>(exceptionResponse, exception.getStatus());
        }


    }

