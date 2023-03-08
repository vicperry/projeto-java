package com.vicperry.projetojava.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@GetMapping("/usuario")
	public String getCadastro() {
		return "/usuario/cadastro";
	}
	
	@GetMapping("/usuario/lista")
	public String getLista() {
		List<Usuario> lista = UsuarioRepository.obterLista();
		System.out.println("Quantidade de usuários = " + lista.size());
		
		for(Usuario usuario : lista) {
			System.out.printf("%s - %s\n", usuario.getNome(), usuario.getEmail());
		}
		
		return "usuario/lista";
	}
	
	@PostMapping("/usuario/incluir")
	public String postCadastro(Usuario usuario) {
		
		UsuarioRepository.incluir(usuario);
		
		return "redirect:/usuario/lista";
	}
	
}
