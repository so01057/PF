package com.zemnnni.common.infrastructure.security.filter.login;

import com.zemnnni.common.infrastructure.security.config.SecurityOptionConfig;
import com.zemnnni.common.infrastructure.security.dto.SignInRequest;
import com.zemnnni.common.infrastructure.security.token.ZemnnniAuthenticationToken;
import com.zemnnni.common.infrastructure.utility.mapper.MapperUtil;
import com.zemnnni.common.infrastructure.utility.request.RequestUtil;
import com.zemnnni.common.share.enums.LoginTypeCode;
import com.zemnnni.common.share.enums.RequestMethod;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class IdPwLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final RequestUtil requestUtil;
    private final MapperUtil mapperUtil;

    public IdPwLoginFilter(SecurityOptionConfig securityOptionConfig, RequestUtil requestUtil, MapperUtil mapperUtil) {
        super(new AntPathRequestMatcher(securityOptionConfig.getSignInFilter().getUrl()));
        this.requestUtil = requestUtil;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        /* TODO 예외처리 개발 후 메시지 설정 필요 */
        if (!RequestMethod.POST.getRequestMethod().equalsIgnoreCase(httpServletRequest.getMethod())) throw new AuthenticationServiceException("NOT POST");

        String requestBody = requestUtil.getRequestBody(httpServletRequest);

        SignInRequest signInRequest = mapperUtil.jsonMapperParser(requestBody, SignInRequest.class);

        String loginId = signInRequest.getLoginId();
        String password = signInRequest.getPassword();

        ZemnnniAuthenticationToken zemnnniAuthenticationToken = new ZemnnniAuthenticationToken(loginId, password, LoginTypeCode.IDPW.getCodeDescription());

        return getAuthenticationManager().authenticate(zemnnniAuthenticationToken);
    }
}
