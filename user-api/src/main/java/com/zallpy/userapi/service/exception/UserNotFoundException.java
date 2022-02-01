package com.zallpy.userapi.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class UserNotFoundException extends RuntimeException {

     protected final HttpStatus status;
     public UserNotFoundException (HttpStatus status , String message){
        super(message);
        this.status = status;

    }
}
