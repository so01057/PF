package com.zemnnni.common.share.enums;

import lombok.Getter;

@Getter
public enum UserStatusCode {
    ACTIVE(1,"활성화"),
    WITHDRAWAL(2,"탈퇴");

    private final Integer codeOrder;
    private final String codeDescription;

    UserStatusCode(Integer codeOrder, String codeDescription) {
        this.codeOrder = codeOrder;
        this.codeDescription = codeDescription;
    }
}
