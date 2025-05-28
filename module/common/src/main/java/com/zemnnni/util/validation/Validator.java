package com.zemnnni.util.validation;

/**
 * @작성자 : DATA
 * @파일명 : Validator
 * @작성일 : 2025-05-28
 * @설명 :
 */
public interface Validator<T> {
    boolean validate(T value);
    String getErrorMessage();
    Class<T> getSupportedType();
}
