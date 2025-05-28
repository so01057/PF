package com.zemnnni.user.model;

import lombok.*;

import java.util.List;

/**
 * @작성자 : DATA
 * @파일명 : UserDetail
 * @작성일 : 2025-05-28
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    private String userId;
    private String userPassword;
    private String userName;
    private List<String> roleList;
}
