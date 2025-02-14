package com.example.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.example.ems")
public class EmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}
}
