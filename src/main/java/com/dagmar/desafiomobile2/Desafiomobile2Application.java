package com.dagmar.desafiomobile2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.dagmar.desafiomobile2.repository")
@ComponentScan(basePackages = {"com.dagmar.desafiomobile2.controller","com.dagmar.desafiomobile2.model","com.dagmar.desafiomobile2.repository"})

public class Desafiomobile2Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafiomobile2Application.class, args);
	}

}
