package az.edu.ada.wm2.first_spring_boot_app.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

public class JPAConfig {

    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:umsDB");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("pass");
        return dataSourceBuilder.build();
    }


}
