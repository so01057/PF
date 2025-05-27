package com.zemnnni.config.encryption;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

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

    /* BASE64 인코딩 포함한 암호화 */
    public static String encryptFromBase64(String plainText, PublicKey publicKey) throws Exception{
        byte[] keyBytes = encrypt(plainText,publicKey);
        return Base64.getEncoder().encodeToString(keyBytes);
    }

    /* BASE64 디코딩 포함한 복호화 */
    public static String decryptFromBase64(String encryptText, PrivateKey privateKey) throws Exception{
        byte[] keyBytes = Base64.getDecoder().decode(encryptText);
        return decrypt(keyBytes,privateKey);
    }

    /* 공개키 조회 */
    public static PublicKey getPublicKeyFromBase64(String publicKeyWithBase64) throws Exception{
        byte[] keyBytes = Base64.getDecoder().decode(publicKeyWithBase64);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);

        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        return publicKey;
    }

    /* 개인키 조회 */
    public static PrivateKey getPrivateKeyFromBase64(String privateKeyWithBase64) throws Exception{
        byte[] keyBytes = Base64.getDecoder().decode(privateKeyWithBase64);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }
}
