package com.zemnnni.auth.model.token;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : Jwt
 * @작성일 : 2025-05-27
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken {
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
    private Long refreshTokenExpiresIn;
}
