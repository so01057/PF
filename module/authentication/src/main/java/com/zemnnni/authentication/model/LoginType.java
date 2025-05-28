package com.zemnnni.authentication.model;

/**
 * @작성자 : DATA
 * @파일명 : LoginType
 * @작성일 : 2025-05-28
 * @설명 :
 */
public enum LoginType {
    basic("basic"),
    token("token"),;

    private final String value;
    LoginType(String value) {
        this.value = value;
    }
}
