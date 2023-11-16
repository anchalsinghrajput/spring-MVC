package com.example.mvcDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {

	@RequestMapping("/")
	public String welcome() {
		System.out.println("Welocome to home page");
		return "welcome";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
