package com.zemnnni.auth.service;

import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.AuthenticationToken;
import com.zemnnni.auth.model.AuthenticationType;
import com.zemnnni.auth.strategy.AuthenticationStrategy;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @작성자 : DATA
 * @파일명 : AuthServiceImpl
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Service
public class AuthServiceImpl implements AuthService {

    private final ApplicationContext applicationContext;
    private final Map<AuthenticationType, AuthenticationStrategy> strategies;

    public AuthServiceImpl(ApplicationContext applicationContext, Map<AuthenticationType, AuthenticationStrategy> strategies) {
        this.applicationContext = applicationContext;
        this.strategies = strategies;
    }

    @Override
    public AuthenticationToken signIn(Auth auth) {
        AuthenticationType authenticationType = auth.getAuthenticationType();
        AuthenticationStrategy authenticationStrategy = strategies.get(authenticationType);

        return authenticationStrategy.authenticate(auth);
    }
}
