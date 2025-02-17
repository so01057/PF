package com.zemnnni.common.infrastructure.security.token;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.io.Serial;
import java.util.Collection;

public class ZemnnniAuthenticationToken extends AbstractAuthenticationToken {
    @Serial
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final String loginId;
    private String password;
    @Getter
    private final String loginTypeCode;

    // 인증 전 생성자
    public ZemnnniAuthenticationToken(String loginId, String password, String loginTypeCode) {
        super(null);
        this.loginId = loginId;
        this.password = password;
        this.loginTypeCode = loginTypeCode;
        setAuthenticated(false);
    }

    // 인증 후 생성자
    public ZemnnniAuthenticationToken(String loginId, String password, String loginTypeCode, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.loginId = loginId;
        this.password = password;
        this.loginTypeCode = loginTypeCode;
        super.setAuthenticated(true);
    }

    @Override
    public Object getPrincipal() {
        return this.loginId;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            /* TODO 예외처리 개발 후 메시지 설정 필요 */
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.password = null;
    }
}
