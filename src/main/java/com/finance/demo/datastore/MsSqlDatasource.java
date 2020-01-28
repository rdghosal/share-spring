package com.finance.demo.datastore;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MsSqlDatasource {
    
    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikaridatasource() {
        return DataSourceBuilder
                    .create()
                    .type(HikariDataSource.class)
                    .build();
    }

}