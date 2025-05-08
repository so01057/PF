package com.zemnnni.auth.strategy;

import com.zemnnni.auth.config.annotation.AuthenticationStrategyType;
import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.AuthenticationToken;
import com.zemnnni.auth.model.AuthenticationType;
import com.zemnnni.user.service.UserService;

/**
 * @작성자 : DATA
 * @파일명 : JWTAuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 :
 */

@AuthenticationStrategyType(AuthenticationType.jwt)
public class JwtAuthenticationStrategy implements AuthenticationStrategy {

    private final UserService userService;

    public JwtAuthenticationStrategy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public AuthenticationToken authenticate(Auth auth) {

        AuthenticationToken authenticatedToken = AuthenticationToken
                .builder()
                .build();
        return authenticatedToken;
    }
}
