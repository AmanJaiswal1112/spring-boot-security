package com.lcwd.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("")
	public String getAllUser() {
		return "Welcome to all user api";
		
	}

}
