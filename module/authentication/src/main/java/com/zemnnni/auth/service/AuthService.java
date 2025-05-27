package com.zemnnni.auth.service;

import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.token.AuthenticationToken;

/**
 * @작성자 : DATA
 * @파일명 : AuthService
 * @작성일 : 2025-05-07
 * @설명 :
 */
public interface AuthService {
    AuthenticationToken signIn(Auth auth);

    AuthenticationToken getToken(Auth auth);
}
