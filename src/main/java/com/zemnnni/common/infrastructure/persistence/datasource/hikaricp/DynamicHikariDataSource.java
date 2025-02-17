package com.zemnnni.common.infrastructure.persistence.datasource.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zemnnni.common.infrastructure.persistence.datasource.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @작성자 : jaemin.shin
 * @파일명 : DynamicHikariDataSource
 * @작성일 : 2025-01-22
 * @설명 :
 */

public class DynamicHikariDataSource extends AbstractRoutingDataSource {
    private final Map<Object, Object> dataSources = new HashMap<>();

    public void addDataSource(String name, String url, String username, String password) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        dataSources.put(name, hikariDataSource);

        setTargetDataSources(dataSources);
        afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceContext();
    }
}
