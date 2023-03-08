package com.vicperry.projetojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String getIndex() {
		return "redirect:/login";
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "index";
	}
	
}
