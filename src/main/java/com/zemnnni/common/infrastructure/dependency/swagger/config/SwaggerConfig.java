package com.zemnnni.common.infrastructure.dependency.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("Zemnnni v0.1")
                .version("1.0.0")
                .description("Zemnnni v0.1"));
    }
}
