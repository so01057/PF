package com.zemnnni.model;

import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * @작성자 : DATA
 * @파일명 : Response
 * @작성일 : 2025-05-26
 * @설명 :
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    public HttpStatus httpStatus;
    public String message;
}
