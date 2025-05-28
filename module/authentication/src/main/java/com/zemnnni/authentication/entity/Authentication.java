package com.zemnnni.authentication.entity;

import com.zemnnni.authentication.model.AuthenticationType;
import com.zemnnni.authentication.model.LoginType;
import com.zemnnni.authentication.model.request.SignInRequest;
import com.zemnnni.authentication.model.request.TokenRequest;
import lombok.Builder;
import lombok.Getter;

/**
 * @작성자 : DATA
 * @파일명 : Auth
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Getter
@Builder
public class Authentication {
    private String userId;
    private String encryptedPassword;

    private AuthenticationType authenticationType;

    public static Authentication fromSignInRequest(SignInRequest signInRequest) {
        return Authentication.builder()
                .userId(signInRequest.getUserId())
                .encryptedPassword(signInRequest.getEncryptedPassword())
                .authenticationType(signInRequest.getAuthenticationType())
                .build();
    }

    public static Authentication fromTokenRequest(TokenRequest tokenRequest) {
        return Authentication.builder()
                .userId(tokenRequest.getUserId())
                .encryptedPassword(tokenRequest.getEncryptedPassword())
                .authenticationType(tokenRequest.getAuthenticationType())
                .build();
    }
}
