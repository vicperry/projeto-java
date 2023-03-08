package com.vicperry.projetojava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.AcessoRepository;

@Controller
public class AcessoController {
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String senha) {
		
		Usuario user = new Usuario(email,senha);
		
		if(AcessoRepository.autenticar(user) != null) {
			return "redirect:/home";
		}
		
		return "redirect:/login";
	}
}