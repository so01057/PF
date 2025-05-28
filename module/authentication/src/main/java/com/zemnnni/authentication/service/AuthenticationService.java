package com.zemnnni.authentication.service;

import com.zemnnni.authentication.entity.Authentication;
import com.zemnnni.authentication.model.token.AuthenticationToken;

/**
 * @작성자 : DATA
 * @파일명 : AuthService
 * @작성일 : 2025-05-07
 * @설명 :
 */
public interface AuthenticationService {
    AuthenticationToken signIn(Authentication authenticationService) throws Exception;

    AuthenticationToken getToken(Authentication authenticationService) throws Exception;
}
