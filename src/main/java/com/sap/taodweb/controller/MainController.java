package com.sap.taodweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/test")
	public String test(Model model, @RequestParam(value="name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "hello";
	}
}
