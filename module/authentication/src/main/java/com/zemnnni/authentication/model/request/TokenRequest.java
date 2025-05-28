package com.zemnnni.authentication.model.request;

import com.zemnnni.authentication.model.AuthenticationType;
import lombok.*;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

/**
 * @작성자 : DATA
 * @파일명 : TokenRequest
 * @작성일 : 2025-05-27
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest {
    @NotBlank
    private String userId;
    @NotBlank
    private String encryptedPassword;
    @NotBlank
    private AuthenticationType authenticationType;

    private String redirectUrl;

    private String serviceId;
    private String secretKey;
}
