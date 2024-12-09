package com.zemnnni.portfolio.infrastructure.security.provider;

import com.zemnnni.portfolio.infrastructure.security.dto.AuthenticatedUserResponse;
import com.zemnnni.portfolio.infrastructure.security.service.SecurityAuthenticationService;
import com.zemnnni.portfolio.infrastructure.security.token.ZemnnniAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class ZemnnniAuthenticationProvider implements AuthenticationProvider {

    private final SecurityAuthenticationService securityAuthenticationService;

    public ZemnnniAuthenticationProvider(SecurityAuthenticationService securityAuthenticationService) {
        this.securityAuthenticationService = securityAuthenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ZemnnniAuthenticationToken zemnnniAuthenticationToken = (ZemnnniAuthenticationToken) authentication;

        String loginId = (String) zemnnniAuthenticationToken.getPrincipal();
        String password = (String) zemnnniAuthenticationToken.getCredentials();

        AuthenticatedUserResponse authenticatedUserResponse = securityAuthenticationService.getAuthenticatedUser(loginId,password);

        /* 20241106 END */
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
