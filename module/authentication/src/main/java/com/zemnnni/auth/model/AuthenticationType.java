package com.zemnnni.auth.model;

import lombok.Getter;

/**
 * @작성자 : DATA
 * @파일명 : AuthenticationType
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Getter
public enum AuthenticationType {
    restAPI("restAPI"),
    OAuth2("OAuth2"),
    saml2("saml2.0"),
    custom("custom"),
    ;

    private final String value;
    AuthenticationType(String value) {
        this.value = value;
    }
}
