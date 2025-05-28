package com.zemnnni.util.validation;

import org.springframework.stereotype.Component;

/**
 * @작성자 : DATA
 * @파일명 : StringValidator
 * @작성일 : 2025-05-28
 * @설명 :
 */

@Component
public class StringValidator implements Validator<String> {
    private String errorMessage;
    @Override
    public boolean validate(String value) {
        if(value == null
                || value.isBlank()){
            errorMessage = "문자열이 비어있습니다.";
            return false;
        }
        return true;
    }
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public Class<String> getSupportedType() {
        return String.class;
    }
}
