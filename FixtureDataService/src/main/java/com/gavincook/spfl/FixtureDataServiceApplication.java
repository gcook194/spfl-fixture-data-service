package com.gavincook.spfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FixtureDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FixtureDataServiceApplication.class, args);
	}

}
