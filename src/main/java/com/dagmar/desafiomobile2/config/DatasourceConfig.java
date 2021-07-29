package com.dagmar.desafiomobile2.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class DatasourceConfig {
	
	@Bean
    public DataSource datasource() {
		
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/desafiomobile2")
                .username("root")
                .password("dagmar87")
                .build();
        
    }

}
