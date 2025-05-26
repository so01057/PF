package com.zemnnni.common.entity.encryption;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : Encryption
 * @작성일 : 2025-05-26
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Encryption {
    private RSAKeyPair rsaKeyPair;
}
