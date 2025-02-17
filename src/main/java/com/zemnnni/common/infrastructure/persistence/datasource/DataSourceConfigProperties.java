package com.zemnnni.common.infrastructure.persistence.datasource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @작성자 : jaemin.shin
 * @파일명 : DataSourceConfigProperties
 * @작성일 : 2025-01-22
 * @설명 : 멀티 DataSource 구성을 위한 Properties
 */

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "datasources")
public class DataSourceConfigProperties {

    private List<DataSourceConfig> dataSourceConfigList;

    @Getter
    @Setter
    public static class DataSourceConfig {
        private String name;
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }
}
