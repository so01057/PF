package com.zemnnni.portfolio.infrastructure.exception.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
    private Integer httpStatusCode;
    private String message;
    private String detail;
}
