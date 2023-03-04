package com.example.payment_task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidAuthorizationException extends RuntimeException{
    public InvalidAuthorizationException(String errorMessage){
        super(errorMessage);
    }
}
