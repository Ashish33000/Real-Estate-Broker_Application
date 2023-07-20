package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BrokerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrokerServiceApplication.class, args);
	}

}
