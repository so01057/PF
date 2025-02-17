package com.zemnnni.common.share.exception.config;

import com.zemnnni.common.infrastructure.exception.*;
import com.zemnnni.common.share.enums.exception.*;
import com.zemnnni.common.share.exception.*;
import com.zemnnni.common.share.exception.IllegalArgumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    /* BadRequestException */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpServletResponse.SC_BAD_REQUEST,e.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatusCode.valueOf(HttpServletResponse.SC_BAD_REQUEST));
    }

    /* ResourceNotFoundException */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpServletResponse.SC_NOT_FOUND,e.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatusCode.valueOf(HttpServletResponse.SC_NOT_FOUND));
    }

    /* ForbiddenException */
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ExceptionResponse> handleForbiddenException(ForbiddenException e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpServletResponse.SC_NOT_FOUND,e.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatusCode.valueOf(HttpServletResponse.SC_NOT_FOUND));
    }

    /* ConflictException */
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionResponse> handleConflictException(ConflictException e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpServletResponse.SC_CONFLICT,e.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatusCode.valueOf(HttpServletResponse.SC_CONFLICT));
    }

    /* UnAuthorizedException */
    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleUnAuthorizedException(UnAuthorizedException e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatusCode.valueOf(HttpServletResponse.SC_UNAUTHORIZED));
    }

    /* InternalServerErrorException */
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ExceptionResponse> handleInternalServerErrorException(InternalServerErrorException e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatusCode.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR));
    }

    /* IllegalArgumentException */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(IllegalArgumentException e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpServletResponse.SC_BAD_REQUEST,e.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(exceptionResponse, HttpStatusCode.valueOf(HttpServletResponse.SC_BAD_REQUEST));
    }
}
