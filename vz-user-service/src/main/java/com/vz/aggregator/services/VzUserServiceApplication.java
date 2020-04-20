package com.vz.aggregator.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.vz.aggregator.services")
@EnableDiscoveryClient
public class VzUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VzUserServiceApplication.class, args);
	}
}
