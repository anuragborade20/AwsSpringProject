package com.infy.SpringAwsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.infy")
public class SpringAwsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAwsAppApplication.class, args);
	}

}
