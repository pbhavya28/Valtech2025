package com.valtech.training.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.springweb.vos.LoginVO;


@Controller
public class HelloController {

	public ModelAndView test() {
		ModelAndView view = new ModelAndView("login");
		view.addObject("message", "Please use Login Dialog");
		return view;
	}
	
	@PostMapping("/login")
	public String handleLoginform(@ModelAttribute LoginVO login, Model model) {
		if("scott".equals(login.getUsername()) && "tiger".equals(login.getPassword())) {
			model.addAttribute("login", login);
			return "dashboard";
		}
		model.addAttribute("message","Invalid username or password");
		return "login";
		/*
		 * We have marked this class as @Controller.
		 * thats why it will return to jsp file and also check yaml file,
		 * there we have provied prefix and suffix
		 * */
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
