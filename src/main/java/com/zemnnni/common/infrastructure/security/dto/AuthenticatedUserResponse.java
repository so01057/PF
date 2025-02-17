package com.zemnnni.common.infrastructure.security.dto;

import lombok.Data;

@Data
public class AuthenticatedUserResponse {
    private String userUid;
    private String loginId;
    private String userName;
}
