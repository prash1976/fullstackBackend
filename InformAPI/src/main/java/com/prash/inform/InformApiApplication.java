package com.prash.inform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.prash.inform")
public class InformApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformApiApplication.class, args);
	}

}

