package com.zallpy.userapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiException extends RuntimeException {

     protected final HttpStatus status;
     public ApiException(HttpStatus status , String message){
        super(message);
        this.status = status;

    }
}
