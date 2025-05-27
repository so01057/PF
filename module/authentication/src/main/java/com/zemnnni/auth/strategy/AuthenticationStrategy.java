package com.zemnnni.auth.strategy;

import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.token.AuthenticationToken;

/**
 * @작성자 : DATA
 * @파일명 : AuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 : 
 */
public interface AuthenticationStrategy {
    AuthenticationToken authenticate(Auth auth);
}
