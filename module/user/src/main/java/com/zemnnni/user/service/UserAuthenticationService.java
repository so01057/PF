package com.zemnnni.user.service;

import com.zemnnni.user.entity.User;
import com.zemnnni.user.entity.UserAuthentication;
import com.zemnnni.user.model.ZemnnniUserDetails;

/**
 * @작성자 : DATA
 * @파일명 : UserAuthenticationService
 * @작성일 : 2025-05-28
 * @설명 :
 */
public interface UserAuthenticationService {
    ZemnnniUserDetails getUserDetails(UserAuthentication userAuthentication);
}
