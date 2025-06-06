package com.zemnnni.user.entity;

import lombok.*;

/**
 * @작성자 : DATA
 * @파일명 : User
 * @작성일 : 2025-05-27
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    private String userPassword;
}
