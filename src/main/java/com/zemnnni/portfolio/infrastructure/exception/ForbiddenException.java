package com.zemnnni.portfolio.infrastructure.exception;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String message){
        super(message);
    }
}
