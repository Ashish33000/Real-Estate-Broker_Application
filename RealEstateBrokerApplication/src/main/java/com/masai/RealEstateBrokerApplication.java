package com.masai;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configurable
public class RealEstateBrokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateBrokerApplication.class, args);
	}

}
