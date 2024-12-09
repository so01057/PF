package com.zemnnni.portfolio.infrastructure.security.dto;

import lombok.Data;

import java.util.List;

@Data
public class SignInUserResponse {
    private String userUid;
    private String loginId;
    private String encryptedPassword;
    private String userName;
    private String userStatusCode;
    private Integer passwordErrorCount;


}
