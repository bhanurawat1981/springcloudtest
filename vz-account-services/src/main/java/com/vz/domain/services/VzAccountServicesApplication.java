package com.vz.domain.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VzAccountServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VzAccountServicesApplication.class, args);
	}

}
