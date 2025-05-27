package com.zemnnni.common.model.encryption.response;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : RSAPrivateKey
 * @작성일 : 2025-05-27
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RSAPrivateKey {
    private String privateKey;
}
