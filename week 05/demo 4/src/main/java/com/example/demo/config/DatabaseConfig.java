package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource createH2DataSource() {
        DataSource ds = DataSourceBuilder.create().build();
        logger.info("datasource", ds);
        return ds;
    }

//    @Bean
//    public DataSource createH2DataSource() {
//        DataSourceBuilder dsBuilder = DataSourceBuilder.create();
//        dsBuilder.driverClassName("org.h2.Driver");
//        dsBuilder.url("jdbc:h2:file:./data/coursesDB;DB_CLOSE_DELAY=-1");
//        dsBuilder.username("user");
//        dsBuilder.password("1234");
//
//        DataSource ds = dsBuilder.build();
//        logger.info("datasource", ds);
//        return ds;
//    }
}