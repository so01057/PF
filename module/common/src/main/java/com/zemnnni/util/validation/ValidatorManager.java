package com.zemnnni.util.validation;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @작성자 : DATA
 * @파일명 : ValidatorManager
 * @작성일 : 2025-05-28
 * @설명 :
 */

@Component
public class ValidatorManager {
    private final Map<Class<?>, Validator<?>> validatorMap = new HashMap<>();

    // 생성자 주입: 스프링이 빈으로 등록된 모든 Validator를 리스트로 주입
    public ValidatorManager(List<Validator<?>> validators) {
        for (Validator<?> validator : validators) {
            validatorMap.put(validator.getSupportedType(), validator);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> boolean validate(T value) {
        if (value == null) return false;

        Validator<T> validator = (Validator<T>) validatorMap.get(value.getClass());
        if (validator == null) {
            throw new RuntimeException("Validator가 등록되어 있지 않습니다: " + value.getClass());
        }
        return validator.validate(value);
    }

    @SuppressWarnings("unchecked")
    public <T> String getErrorMessage(T value) {
        Validator<T> validator = (Validator<T>) validatorMap.get(value.getClass());
        if (validator == null) {
            return "Validator가 없습니다.";
        }
        return validator.getErrorMessage();
    }
}
