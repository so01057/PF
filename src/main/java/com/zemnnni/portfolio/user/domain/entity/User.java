package com.zemnnni.portfolio.user.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(schema = "portfolio", name = "user")
public class User {
    @Id
    private String userUid;

    @Column(name = "user_id")
    private String userId;
    @Column(name = "encrypted_password")
    private String encryptedPassword;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_status_code")
    private String userStatusCode;
    @Column(name = "sign_up_type_code")
    private String signUpTypeCode;
    @Column(name = "password_error_count")
    private Integer passwordErrorCount;
}
