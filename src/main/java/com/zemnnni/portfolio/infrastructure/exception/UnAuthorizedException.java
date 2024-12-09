package com.zemnnni.portfolio.infrastructure.exception;

public class UnAuthorizedException extends RuntimeException{
    public UnAuthorizedException(String message){
        super(message);
    }
}
