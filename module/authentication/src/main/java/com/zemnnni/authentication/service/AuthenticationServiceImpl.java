package com.zemnnni.authentication.service;

import com.zemnnni.authentication.entity.Authentication;
import com.zemnnni.authentication.model.token.AuthenticationToken;
import com.zemnnni.authentication.model.AuthenticationType;
import com.zemnnni.authentication.strategy.AuthenticationStrategy;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @작성자 : DATA
 * @파일명 : AuthServiceImpl
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final ApplicationContext applicationContext;
    private final Map<AuthenticationType, AuthenticationStrategy> strategies;

    public AuthenticationServiceImpl(ApplicationContext applicationContext, Map<AuthenticationType, AuthenticationStrategy> strategies) {
        this.applicationContext = applicationContext;
        this.strategies = strategies;
    }

    @Override
    public AuthenticationToken signIn(Authentication auth) throws Exception {
        AuthenticationType authenticationType = auth.getAuthenticationType();
        AuthenticationStrategy authenticationStrategy = strategies.get(authenticationType);

        return authenticationStrategy.authenticate(auth);
    }

    @Override
    public AuthenticationToken getToken(Authentication auth) throws Exception {
        AuthenticationType authenticationType = auth.getAuthenticationType();
        AuthenticationStrategy authenticationStrategy = strategies.get(authenticationType);
        return authenticationStrategy.authenticate(auth);
    }
}
