package com.active;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = { "classpath:config/context.xml" })
public class ActiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveApplication.class, args);
	}
}
