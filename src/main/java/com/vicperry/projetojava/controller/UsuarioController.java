package com.vicperry.projetojava.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	private String mensagem;

	@GetMapping("/usuario")
	public String getCadastro() {
		return "/usuario/cadastro";
	}

	@GetMapping("/usuario/lista")
	public String getLista(Model model) {
		model.addAttribute("usuarios", UsuarioRepository.obterLista());
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
//		List<Usuario> lista = UsuarioRepository.obterLista();
//		System.out.println("Quantidade de usuários = " + lista.size());
//		
//		for(Usuario usuario : lista) {
//			System.out.printf("%s - %s\n", usuario.getNome(), usuario.getEmail());
//		}
//		
		return "usuario/lista";
	}

	@PostMapping("/usuario/incluir")
	public String postCadastro(Usuario usuario) {

		UsuarioRepository.incluir(usuario);
		
		mensagem = "A inclusão do usuário "+usuario.getNome()+" foi realizada com sucesso!!!";


		return "redirect:/usuario/lista";
	}
	
	@GetMapping("/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		Usuario usuario = UsuarioRepository.excluir(id);
		mensagem = "A exclusão do usuário "+usuario.getNome()+" foi realizada com sucesso!!!";
		return "redirect:/usuario/lista";
	}
	
}
