package com.zemnnni.authentication.model.token;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : AuthenticationToken
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Builder
public class AuthenticationToken {
    private JwtToken jwtToken;

}
