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

    @Value("postgres://amipzhwpjwksvv:44855e91eb7a0ba269c0a74e41aa238670c7d72ac79bffcf3388de0502ce8f74@ec2-174-129-33-167.compute-1.amazonaws.com:5432/d40052gvs96rhq")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }


}
