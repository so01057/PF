package com.zemnnni.auth.config.annotation;

import com.zemnnni.auth.model.AuthenticationType;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @작성자 : DATA
 * @파일명 : AuthenticationStrategyType
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface AuthenticationStrategyType {
    AuthenticationType value();
}
