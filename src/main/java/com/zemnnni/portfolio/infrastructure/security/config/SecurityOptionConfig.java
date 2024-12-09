package com.zemnnni.portfolio.infrastructure.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "option.security.filter")
public class SecurityOptionConfig {
    private SignInFilter signInFilter;

    @Data
    public static class SignInFilter {
        private boolean enabled;
        private String method;
        private String url;
    }

    private SignOutFilter signOutFilter;

    @Data
    public static class SignOutFilter{
        private boolean enabled;
        private String method;
        private String url;
    }
}
