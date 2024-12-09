package com.zemnnni.portfolio.infrastructure.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
