package com.zemnnni.common.infrastructure.security.service;

import com.zemnnni.common.share.exception.IllegalArgumentException;
import com.zemnnni.common.infrastructure.security.dto.AuthenticatedUserResponse;
import com.zemnnni.common.infrastructure.security.dto.SignInUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecurityAuthenticationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityAuthenticationService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Value("${option.security.sign-in.try-count.limit}")
    private Integer signInTryCountLimit;

    public AuthenticatedUserResponse getAuthenticatedUser(String loginId, String password) {
        AuthenticatedUserResponse authenticatedUserResponse = null;
        SignInUserResponse signInUserResponse = userRepository.findUserByLoginId(loginId);

        /* 인증/인가 로직 */
        checkAuthentication(password, signInUserResponse);

        /* 비밀번호 오류횟수 확인 로직 */
        checkLoginTryCountLimit(signInUserResponse);

        /* 20241107 비밀번호 오류횟수 체크 진행중 END */


        return authenticatedUserResponse;
    }

    public void checkLoginTryCountLimit(SignInUserResponse signInUserResponse) {
        Integer passwordErrorCount = signInUserResponse.getPasswordErrorCount();

        /* 비밀번호 오류횟수가 오류제한 횟수 이상일때 TODO 예외처리 개발 후 메시지 설정 필요 */
        if(passwordErrorCount <= signInTryCountLimit) throw new IllegalArgumentException("");
    }

    public void checkAuthentication(String password, SignInUserResponse signInUserResponse){
        String encryptedPassword = signInUserResponse.getEncryptedPassword();
        String userStatusCode = signInUserResponse.getUserStatusCode();

        /* 유저상태코드가 활성화 상태인지 체크
        TODO userStatusCode Enum클래스 생성
        TODO 예외처리 개발 후 메시지 설정 필요*/
        if(!userStatusCode.equalsIgnoreCase("ENUM_userStatusCode.ACTIVE")) throw new IllegalArgumentException("");

        /* Spring Security bCryptPasswordEncoder 비밀번호 암호화값 체크
        TODO 예외처리 개발 후 메시지 설정 필요 */
        if(!bCryptPasswordEncoder.matches(password,encryptedPassword)) throw new IllegalArgumentException("");

    }
}
