package com.zemnnni.common.infrastructure.persistence.datasource;

/**
 * @작성자 : jaemin.shin
 * @파일명 : DataSourceContextHolder
 * @작성일 : 2025-01-22
 * @설명 : DataSource 동적 CRUD
 */

public class DataSourceContextHolder {

    private static final ThreadLocal<String> dataSourceContextHolder = new ThreadLocal<>();

    /* DataSource 설정 */
    public static void setDataSourceContext(String dataSource) {
        dataSourceContextHolder.set(dataSource);
    }

    /* DataSource 조회 */
    public static String getDataSourceContext() {
        return dataSourceContextHolder.get();
    }

    /* DataSource 삭제 */
    public static void clearDataSourceContext() {
        dataSourceContextHolder.remove();
    }
}
