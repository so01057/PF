package com.zemnnni.config.encryption;

import javax.crypto.Cipher;
import java.security.*;

/**
 * @작성자 : zemnnni
 * @파일명 : RSAUtil
 * @작성일 : 2025-05-26
 * @설명 : RSA 암호화 유틸클래스
 */

public class RSAUtil {

    private static final String ALGORITHM = "RSA";

    /* 공개키/개인키 생성 */
    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    /* 공개키 암호화 */
    public static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception{
        Cipher encryptCipher = Cipher.getInstance(ALGORITHM);
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return encryptCipher.doFinal(plainText.getBytes());
    }

    /* 개인키 복호화 */
    public static String decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception{
        Cipher decryptCipher = Cipher.getInstance(ALGORITHM);
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decryptCipher.doFinal(cipherText);
        return new String(decryptedBytes);
    }
}
