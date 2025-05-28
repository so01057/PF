package com.zemnnni.user.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @작성자 : DATA
 * @파일명 : ZemnnniUserDetail
 * @작성일 : 2025-05-28
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZemnnniUserDetails implements UserDetails {

    private UserDetail userDetail;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return userDetail.getUserPassword();
    }

    @Override
    public String getUsername() {
        return userDetail.getUserId();
    }
}
