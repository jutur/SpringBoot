package com.example.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext  = SpringApplication.run(Application.class, args); // Will activate the spring container

		System.out.println("-------------------------------------------------");
		for (String name: applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		System.out.println("-------------------------------------------------");
	}

}
