package com.zemnnni.portfolio.infrastructure.utility.request;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;

@Component
public class RequestUtil {
    public String getRequestBody(HttpServletRequest request) throws BadRequestException {
        try (BufferedReader bufferedReader = request.getReader()) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) stringBuilder.append(line);

            return stringBuilder.toString();
        } catch (Exception e) {
            /* TODO 예외처리 개발 후 메시지 설정 필요 */
            throw new BadRequestException(e);
        }
    }
}
