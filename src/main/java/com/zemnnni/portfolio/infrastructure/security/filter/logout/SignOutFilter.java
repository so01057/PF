package com.zemnnni.portfolio.infrastructure.security.filter.logout;

import com.zemnnni.portfolio.infrastructure.security.config.SecurityOptionConfig;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SignOutFilter extends OncePerRequestFilter {

    private final SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();

    private final SecurityOptionConfig securityOptionConfig;

    public SignOutFilter(SecurityOptionConfig securityOptionConfig) {
        this.securityOptionConfig = securityOptionConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String logoutUrl = securityOptionConfig.getSignOutFilter().getUrl();
        String logoutMethod = securityOptionConfig.getSignOutFilter().getMethod();
        String requestURI = httpServletRequest.getRequestURI();
        String requestMethod = httpServletRequest.getMethod();

        if (logoutUrl.equalsIgnoreCase(requestURI) && logoutMethod.equalsIgnoreCase(requestMethod)) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) securityContextLogoutHandler.logout(httpServletRequest, httpServletResponse, authentication);
            /* TODO 로그아웃 완료 응답 송신 */
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }


    }
}
