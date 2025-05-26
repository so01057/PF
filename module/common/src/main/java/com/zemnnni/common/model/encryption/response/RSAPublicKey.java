package com.zemnnni.common.model.encryption.response;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : RSAPublicKey
 * @작성일 : 2025-05-26
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RSAPublicKey {
    private String publicKey;
}
