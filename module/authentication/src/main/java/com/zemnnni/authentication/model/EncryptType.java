package com.zemnnni.authentication.model;

/**
 * @작성자 : DATA
 * @파일명 : EncryptType
 * @작성일 : 2025-05-28
 * @설명 :
 */
public enum EncryptType {
    RSA("RSA"),
    Bcrypt("BCrypt"),;

    private final String value;
    EncryptType(String value) {
        this.value = value;
    }
}
