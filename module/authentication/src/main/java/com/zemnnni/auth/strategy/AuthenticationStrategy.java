package com.zemnnni.auth.strategy;

import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.AuthenticationToken;
import com.zemnnni.auth.model.request.SignInRequest;

/**
 * @작성자 : DATA
 * @파일명 : AuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 : 
 */
public interface AuthenticationStrategy {
    AuthenticationToken authenticate(Auth auth);
}
