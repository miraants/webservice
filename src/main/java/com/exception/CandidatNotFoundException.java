package com.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CandidatNotFoundException extends RuntimeException{
    public CandidatNotFoundException(String message) {
        super(message);
    }
}
