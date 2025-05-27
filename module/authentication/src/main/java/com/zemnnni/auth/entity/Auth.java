package com.zemnnni.auth.entity;

import com.zemnnni.auth.model.AuthenticationType;
import com.zemnnni.auth.model.request.SignInRequest;
import com.zemnnni.auth.model.request.TokenRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @작성자 : DATA
 * @파일명 : Auth
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Getter
@Builder
public class Auth {
    private String loginId;
    private String encryptedPassword;

    private AuthenticationType authenticationType;

    public static Auth fromSignInRequest(SignInRequest signInRequest) {
        return Auth.builder()
                .authenticationType(signInRequest.getAuthenticationType())
                .build();
    }

    public static Auth fromTokenRequest(TokenRequest tokenRequest) {
        return Auth.builder()

                .build();
    }
}
