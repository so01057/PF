package com.zemnnni.authentication.model.request;

import com.zemnnni.authentication.model.AuthenticationType;
import lombok.Data;

/**
 * @작성자 : DATA
 * @파일명 : SignInRequest
 * @작성일 : 2025-05-07
 * @설명 :
 */
@Data
public class SignInRequest {
    private AuthenticationType authenticationType;
    private String userId;
    private String encryptedPassword;
    private String redirectUrl;
}
