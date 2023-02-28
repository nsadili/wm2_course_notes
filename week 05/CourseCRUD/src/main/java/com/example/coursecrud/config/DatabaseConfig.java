package com.example.coursecrud.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
}
