package com.zemnnni.portfolio.infrastructure.exception;

public class ConflictException extends RuntimeException{
    public ConflictException (String message){
        super(message);
    }
}
