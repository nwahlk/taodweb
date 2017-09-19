package com.sap.taodweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.taodweb.service.HelloService;


@RestController
public class HelloController {
	@Autowired
	private HelloService service;

	@RequestMapping("/hello")
	public String hello() {
		return service.retrieveHelloMessage();
	}
}
