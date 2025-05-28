package com.zemnnni.authentication.model.token;

import lombok.*;

import java.util.List;

/**
 * @작성자 : DATA
 * @파일명 : UserInformation
 * @작성일 : 2025-05-28
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {
    private String userId;
    private String userName;
    private List<String> roleList;
}
