package com.example.section4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.section4.*")
public class Section4Application {

	public static void main(String[] args) {
		SpringApplication.run(Section4Application.class, args);
	}
}
