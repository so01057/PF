package com.zemnnni.authentication.strategy;

import com.zemnnni.authentication.config.annotation.AuthenticationStrategyType;
import com.zemnnni.authentication.entity.Authentication;
import com.zemnnni.authentication.model.token.AuthenticationToken;
import com.zemnnni.authentication.model.AuthenticationType;

/**
 * @작성자 : DATA
 * @파일명 : Saml2AuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 :
 */

@AuthenticationStrategyType(AuthenticationType.saml2)
public class Saml2AuthenticationStrategy implements AuthenticationStrategy {
    @Override
    public AuthenticationToken authenticate(Authentication auth) {
        return null;
    }
}
