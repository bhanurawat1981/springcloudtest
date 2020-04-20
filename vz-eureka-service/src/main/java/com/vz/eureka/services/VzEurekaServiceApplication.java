package com.vz.eureka.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class VzEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VzEurekaServiceApplication.class, args);
	}

}
