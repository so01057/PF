package com.zemnnni.portfolio.infrastructure.security.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String loginId;
    private String password;
}
