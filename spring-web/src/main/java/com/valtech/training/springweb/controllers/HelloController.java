package com.valtech.training.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.springweb.vos.LoginVO;

@Controller
public class HelloController {

	@PostMapping("/login")
	public String handleLoginform(@ModelAttribute LoginVO login) {
		if("scott".equals(login.getUsername()) && "tiger".equals(login.getPassword()))
			return "dashboard";
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring web";
	}
}
