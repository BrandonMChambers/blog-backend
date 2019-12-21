package com.blogger.blogcast.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

//@Configuration
//@Profile("cloud")
public class DataSourceConfiguration {

//    private static final String USER = System.getenv("DB_UN");
//    private static final String PASS = System.getenv("DB_PW");
//    private static final String URL = System.getenv("DB_URL");
//
//    @Bean
//    public DataSource dataSource() {
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setUsername(USER);
//        hikariConfig.setPassword(PASS);
//        hikariConfig.setJdbcUrl(URL);
//        hikariConfig.setDriverClassName("org.postgres.Driver");
//
//        return new HikariDataSource((hikariConfig));
//    }

}
