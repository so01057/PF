package com.zemnnni.auth.strategy;

import com.zemnnni.auth.config.annotation.AuthenticationStrategyType;
import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.AuthenticationToken;
import com.zemnnni.auth.model.AuthenticationType;

/**
 * @작성자 : DATA
 * @파일명 : RestAPIAuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 :
 */

@AuthenticationStrategyType(AuthenticationType.restAPI)
public class RestAPIAuthenticationStrategy implements AuthenticationStrategy {

    @Override
    public AuthenticationToken authenticate(Auth auth) {
        return AuthenticationToken.builder()
                .build();
    }
}
