package com.zemnnni.auth.strategy;

import com.zemnnni.auth.config.annotation.AuthenticationStrategyType;
import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.token.AuthenticationToken;
import com.zemnnni.auth.model.AuthenticationType;

/**
 * @작성자 : DATA
 * @파일명 : OAuth2AuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 :
 */

@AuthenticationStrategyType(AuthenticationType.OAuth2)
public class OAuth2AuthenticationStrategy implements AuthenticationStrategy {
    @Override
    public AuthenticationToken authenticate(Auth auth) {
        return null;
    }
}
