package com.database.MultipleDatabaseConfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "oracleDatasourceConfig")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    @Primary
    public DataSource oracleSqlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlDatasourceConfig")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mySqlDataSource(){
        return DataSourceBuilder.create().build();
    }
}
