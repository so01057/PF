package com.zemnnni.authentication.strategy;

import com.zemnnni.authentication.entity.Authentication;
import com.zemnnni.authentication.model.token.AuthenticationToken;

/**
 * @작성자 : DATA
 * @파일명 : AuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 : 
 */
public interface AuthenticationStrategy {
    AuthenticationToken authenticate(Authentication auth) throws Exception;
}
