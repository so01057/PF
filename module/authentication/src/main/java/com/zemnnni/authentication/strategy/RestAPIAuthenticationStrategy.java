package com.zemnnni.authentication.strategy;

import com.zemnnni.authentication.config.annotation.AuthenticationStrategyType;
import com.zemnnni.authentication.config.util.JwtUtil;
import com.zemnnni.authentication.entity.Authentication;
import com.zemnnni.authentication.model.EncryptType;
import com.zemnnni.authentication.model.token.AuthenticationToken;
import com.zemnnni.authentication.model.AuthenticationType;
import com.zemnnni.authentication.model.token.JwtToken;
import com.zemnnni.authentication.model.token.UserInformation;
import com.zemnnni.common.service.encryption.EncryptionService;
import com.zemnnni.user.entity.UserAuthentication;
import com.zemnnni.user.model.ZemnnniUserDetails;
import com.zemnnni.user.service.UserAuthenticationService;
import com.zemnnni.util.encryption.RSAUtil;
import com.zemnnni.util.validation.ValidatorManager;
import org.springframework.beans.factory.annotation.Value;

import java.security.PrivateKey;
import java.util.ArrayList;

/**
 * @작성자 : DATA
 * @파일명 : RestAPIAuthenticationStrategy
 * @작성일 : 2025-05-07
 * @설명 :
 */

@AuthenticationStrategyType(AuthenticationType.restAPI)
public class RestAPIAuthenticationStrategy implements AuthenticationStrategy {

    private final EncryptionService encryptionService;
    @Value("${encryption.type.user.password}")
    private EncryptType userPasswordEncryptType;

    private final UserAuthenticationService userAuthenticationService;
    private final ValidatorManager validatorManager;
    private final JwtUtil jwtUtil;

    public RestAPIAuthenticationStrategy(UserAuthenticationService userAuthenticationService, ValidatorManager validatorManager, JwtUtil jwtUtil, EncryptionService encryptionService) {
        this.userAuthenticationService = userAuthenticationService;
        this.validatorManager = validatorManager;
        this.jwtUtil = jwtUtil;
        this.encryptionService = encryptionService;
    }

    @Override
    public AuthenticationToken authenticate(Authentication authentication) throws Exception {
        String userId = authentication.getUserId();
        String encryptedPassword = authentication.getEncryptedPassword();

        /* TODO 예외처리 적용 */
        /* ID, PASSWORD null 체크 */
        if(!validatorManager.validate(userId) || !validatorManager.validate(encryptedPassword)) {
            throw new RuntimeException();
        }

        /* 유저 정보 확인 */
        ZemnnniUserDetails zemnnniUserDetails = userAuthenticationService.getUserDetails(
                UserAuthentication.builder()
                        .userId(userId)
                        .build()
                );

        String decryptPassword;

        switch (userPasswordEncryptType){
            case RSA:
                decryptPassword = encryptionService.getRsaDecryptWithBase64(encryptedPassword);
                break;
            case Bcrypt:
                String bcryptedPassword = zemnnniUserDetails.getPassword();


        }

        /* 토큰에 들어갈 정보 객체 생성 */
        UserInformation userInformation = UserInformation.builder()
                .userId(zemnnniUserDetails.getUsername())
                .userName(zemnnniUserDetails.getUsername())
                .roleList(new ArrayList<>())
                .build();

        String accessToken = jwtUtil.generateAccessToken(userInformation,userId);
        String refreshToken = jwtUtil.generateRefreshToken(userInformation,userId);
        int accessTokenExpiresIn = jwtUtil.getAccessTokenExpiration();
        int refreshTokenExpiresIn = jwtUtil.getRefreshTokenExpiration();

        return AuthenticationToken.builder()
                .jwtToken(JwtToken.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .accessTokenExpiresIn(accessTokenExpiresIn)
                        .refreshTokenExpiresIn(refreshTokenExpiresIn)
                        .build())
                .build();
    }
}
