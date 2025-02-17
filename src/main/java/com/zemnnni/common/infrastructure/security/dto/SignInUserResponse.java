package com.zemnnni.common.infrastructure.security.dto;

import lombok.Data;

@Data
public class SignInUserResponse {
    private String userUid;
    private String loginId;
    private String encryptedPassword;
    private String userName;
    private String userStatusCode;
    private Integer passwordErrorCount;


}
