package com.zemnnni.common.infrastructure.security.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String loginId;
    private String password;
}
