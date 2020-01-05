package com.blogger.blogcast.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("cloud")
public class DataSourceConfiguration {

    @Value("postgres://ddcslyyvigrmjp:b840d1c45e2d9582e18373a0c77a95881251e9b2c33cd7776448cfd1030ad2b5@ec2-174-129-242-183.compute-1.amazonaws.com:5432/d3k8frnjnf3nb9")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }


}
