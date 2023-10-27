package com.lab3.ver1.config;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DatasourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.main")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource)
    {
        JdbcTemplate template;
        try
        {
            Connection connection = hikariDataSource.getConnection();
            template = new JdbcTemplate(connection);
            return template;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
