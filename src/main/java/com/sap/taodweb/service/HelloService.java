package com.sap.taodweb.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	public String retrieveHelloMessage() {
		return "Hello World from service";
	}
}