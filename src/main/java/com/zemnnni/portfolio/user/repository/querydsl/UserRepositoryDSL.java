package com.zemnnni.portfolio.user.repository.querydsl;

import com.zemnnni.portfolio.infrastructure.security.dto.SignInUserResponse;

public interface UserRepositoryDSL {
    SignInUserResponse findUserByLoginId(String loginId);
}
