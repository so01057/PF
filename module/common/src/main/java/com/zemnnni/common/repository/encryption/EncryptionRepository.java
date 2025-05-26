package com.zemnnni.common.repository.encryption;

import com.zemnnni.common.entity.encryption.Encryption;
import com.zemnnni.common.model.encryption.response.RSAPublicKey;

/**
 * @작성자 : DATA
 * @파일명 : EncryptionRepository
 * @작성일 : 2025-05-26
 * @설명 :
 */
public interface EncryptionRepository {
    void createRsaKey(Encryption encryption);

    RSAPublicKey getRsaPublicKey();
}
