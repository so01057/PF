package com.zemnnni.common.service.encryption;

import com.zemnnni.common.model.encryption.response.RSAPublicKey;

import java.security.NoSuchAlgorithmException;

/**
 * @작성자 : DATA
 * @파일명 : EncryptionService
 * @작성일 : 2025-05-26
 * @설명 :
 */
public interface EncryptionService {
    void createRsaKey() throws NoSuchAlgorithmException;

    RSAPublicKey getRsaPublicKey();

    String getRsaEncryptWithBase64(String plainText) throws Exception;
    String getRsaDecryptWithBase64(String encryptedText) throws Exception;
}
