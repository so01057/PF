package com.zemnnni.auth.model.request;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : TokenRequest
 * @작성일 : 2025-05-27
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest {
    private String userId;
    private String userPassword;

    private String serviceId;
    private String secretKey;
}
