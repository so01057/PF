package com.zemnnni.auth.model.request;

import com.zemnnni.auth.model.AuthenticationType;
import lombok.Data;

/**
 * @작성자 : DATA
 * @파일명 : SignInRequest
 * @작성일 : 2025-05-07
 * @설명 :
 */
@Data
public class SignInRequest {
    private AuthenticationType authenticationType;
}
