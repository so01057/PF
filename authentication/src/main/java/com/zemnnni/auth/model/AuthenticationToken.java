package com.zemnnni.auth.model;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : AuthenticationToken
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Builder
public class AuthenticationToken {

    private Jwt jwt;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Jwt{
        private String accessToken;
        private String refreshToken;
        private Long accessTokenExpiresIn;
        private Long refreshTokenExpiresIn;
    }
}
