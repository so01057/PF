package com.zemnnni.portfolio.share.enums;

import lombok.Getter;

@Getter
public enum RequestMethod {
    GET("get"),
    POST("post"),
    PATCH("patch"),
    PUT("put"),
    DELETE("delete");

    private final String requestMethod;

    RequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
}
