package com.zemnnni.common.service.encryption;

import com.zemnnni.common.entity.encryption.Encryption;
import com.zemnnni.common.entity.encryption.RSAKeyPair;
import com.zemnnni.common.model.encryption.response.RSAPrivateKey;
import com.zemnnni.common.model.encryption.response.RSAPublicKey;
import com.zemnnni.common.repository.encryption.EncryptionRepository;
import com.zemnnni.util.encryption.RSAUtil;
import org.springframework.stereotype.Service;

import java.security.*;
import java.util.Base64;

/**
 * @작성자 : DATA
 * @파일명 : EncryptionServiceImpl
 * @작성일 : 2025-05-26
 * @설명 :
 */

@Service
public class EncryptionServiceImpl implements EncryptionService {

    private final EncryptionRepository encryptionRepository;

    public EncryptionServiceImpl(EncryptionRepository encryptionRepository) {
        this.encryptionRepository = encryptionRepository;
    }

    @Override
    public void createRsaKey() throws NoSuchAlgorithmException {
        KeyPair rsaKeyPair = RSAUtil.generateKeyPair();

        byte[] publicKey = rsaKeyPair.getPublic().getEncoded();
        byte[] privateKey = rsaKeyPair.getPrivate().getEncoded();

        String publicKeyWithBase64 = Base64.getEncoder().encodeToString(publicKey);
        String privateKeyWithBase64 = Base64.getEncoder().encodeToString(privateKey);

        Encryption encryption = Encryption.builder()
                .rsaKeyPair(
                        RSAKeyPair.builder()
                                .publicKeyWithBase64(publicKeyWithBase64)
                                .privateKeyWithBase64(privateKeyWithBase64)
                                .build())
                .build();

        encryptionRepository.createRsaKey(encryption);
    }

    @Override
    public RSAPublicKey getRsaPublicKey() {
        RSAPublicKey rsaPublicKey = encryptionRepository.getRsaPublicKey();
        return rsaPublicKey;
    }

    @Override
    public String getRsaEncryptWithBase64(String plainText) throws Exception {
        RSAPublicKey rsaPublicKey = encryptionRepository.getRsaPublicKey();

        String publicKeyWithBase64 = rsaPublicKey.getPublicKey();

        PublicKey publicKey = RSAUtil.getPublicKeyFromBase64(publicKeyWithBase64);
        return RSAUtil.encryptFromBase64(plainText,publicKey);
    }

    @Override
    public String getRsaDecryptWithBase64(String encryptedText) throws Exception {
        RSAPrivateKey rsaPrivateKey = encryptionRepository.getRsaPrivateKey();

        String privateKeyWithBase64 = rsaPrivateKey.getPrivateKey();

        PrivateKey privateKey = RSAUtil.getPrivateKeyFromBase64(privateKeyWithBase64);
        return RSAUtil.decryptFromBase64(encryptedText,privateKey);
    }
}
