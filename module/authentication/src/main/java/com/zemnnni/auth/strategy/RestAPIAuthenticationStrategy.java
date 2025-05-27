package com.zemnnni.auth.strategy;

import com.zemnnni.auth.config.annotation.AuthenticationStrategyType;
import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.token.AuthenticationToken;
import com.zemnnni.auth.model.AuthenticationType;
import com.zemnnni.user.service.UserService;

/**
 * @작성자 : DATA
 * @파일명 : RestAPIAuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 :
 */

@AuthenticationStrategyType(AuthenticationType.restAPI)
public class RestAPIAuthenticationStrategy implements AuthenticationStrategy {

    private final UserService userService;

    public RestAPIAuthenticationStrategy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public AuthenticationToken authenticate(Auth auth) {
        String userId = auth.getLoginId();
        String password = auth.getEncryptedPassword();


        return AuthenticationToken.builder()
                .build();
    }
}
