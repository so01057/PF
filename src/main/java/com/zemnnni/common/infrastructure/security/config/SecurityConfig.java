package com.zemnnni.common.infrastructure.security.config;

import com.zemnnni.common.infrastructure.security.filter.login.IdPwLoginFilter;
import com.zemnnni.common.infrastructure.security.filter.logout.SignOutFilter;
import com.zemnnni.common.infrastructure.utility.mapper.MapperUtil;
import com.zemnnni.common.infrastructure.utility.request.RequestUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableRedisHttpSession
@EnableRedisRepositories
public class SecurityConfig {

    private final CorsConfigurationSource corsConfigurationSource;

    private final SecurityOptionConfig securityOptionConfig;

    private final RequestUtil requestUtil;
    private final MapperUtil mapperUtil;

    public SecurityConfig(CorsConfigurationSource corsConfigurationSource, SecurityOptionConfig securityOptionConfig, RequestUtil requestUtil, MapperUtil mapperUtil) {
        this.corsConfigurationSource = corsConfigurationSource;
        this.securityOptionConfig = securityOptionConfig;
        this.requestUtil = requestUtil;
        this.mapperUtil = mapperUtil;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                /* API환경이지만 redis에서 세션관리하는 기능이 있음 */
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                )
                /* TODO 추후 권한 설정시 수정 */
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll()
                );
        /* LoginFilter 사용 여부 체크 */
        if (securityOptionConfig.getSignInFilter().isEnabled()) {
            httpSecurity.addFilterBefore(new IdPwLoginFilter(securityOptionConfig, requestUtil, mapperUtil), UsernamePasswordAuthenticationFilter.class);
        }
        if (securityOptionConfig.getSignOutFilter().isEnabled()) {
            httpSecurity.addFilterBefore(new SignOutFilter(securityOptionConfig), UsernamePasswordAuthenticationFilter.class);
        }
        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
