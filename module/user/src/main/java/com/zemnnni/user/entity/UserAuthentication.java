package com.zemnnni.user.entity;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : UserAuthentication
 * @작성일 : 2025-05-28
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthentication {
    private String userId;
    private String userPassword;
}
