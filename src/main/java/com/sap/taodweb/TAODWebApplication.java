package com.sap.taodweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sap.taodweb")
public class TAODWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TAODWebApplication.class, args);
	}
}
