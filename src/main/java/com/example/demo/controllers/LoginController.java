package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/authorization")
	public String authorizationPage() {
		return "authorization";
	}
	
	@GetMapping("/registration")
	public String registrationPage() {
		return "registration";
	}
}
