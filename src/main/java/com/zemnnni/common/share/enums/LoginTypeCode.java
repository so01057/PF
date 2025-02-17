package com.zemnnni.common.share.enums;

import lombok.Getter;

@Getter
public enum LoginTypeCode {
    IDPW(1,"IdPassword"),
    SSO(2,"sso"),
    OAUTH(3,"OAuth");

    private final Integer codeOrder;
    private final String codeDescription;

    LoginTypeCode(Integer codeOrder, String codeDescription) {
        this.codeOrder = codeOrder;
        this.codeDescription = codeDescription;
    }
}
