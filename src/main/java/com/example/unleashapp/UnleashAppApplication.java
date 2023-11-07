package com.example.unleashapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ServletComponentScan
@SpringBootApplication
public class UnleashAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnleashAppApplication.class, args);
	}
}
