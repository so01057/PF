package com.zemnnni.common.infrastructure.persistence.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @작성자 : jaemin.shin
 * @파일명 : DynamicDataSourceConfig
 * @작성일 : 2025-01-22
 * @설명 : 멀티 DataSource Bean 설정
 */

@Configuration
public class DynamicDataSourceConfig {

    private final DataSourceConfigProperties dataSourceConfigProperties;

    public DynamicDataSourceConfig(DataSourceConfigProperties dataSourceConfigProperties) {
        this.dataSourceConfigProperties = dataSourceConfigProperties;
    }

    @Bean
    public Map<String, DataSource> dataSources() {
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        for(DataSourceConfigProperties.DataSourceConfig dataSourceConfig : dataSourceConfigProperties.getDataSourceConfigList()){
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClassName(dataSourceConfig.getDriverClassName());
            driverManagerDataSource.setUrl(dataSourceConfig.getUrl());
            driverManagerDataSource.setUsername(dataSourceConfig.getUsername());
            driverManagerDataSource.setPassword(dataSourceConfig.getPassword());
            dataSourceMap.put(dataSourceConfig.getName(), driverManagerDataSource);
        }
        return dataSourceMap;
    }
}
