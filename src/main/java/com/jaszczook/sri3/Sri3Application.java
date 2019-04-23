package com.jaszczook.sri3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Sri3Application {

	public static void main(String[] args) {
		SpringApplication.run(Sri3Application.class, args);
	}

}
