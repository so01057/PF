package com.zemnnni.portfolio.infrastructure.exception;

public class InternalServerErrorException extends RuntimeException{
    public InternalServerErrorException(String message){
        super(message);
    }
}
