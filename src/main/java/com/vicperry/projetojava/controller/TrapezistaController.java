package com.vicperry.projetojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.vicperry.projetojava.model.domain.Trapezista;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.TrapezistaService;

@Controller
public class TrapezistaController {
	@Autowired
	private TrapezistaService trapezistaService;

	private String msg;

	@GetMapping(value = "/trapezista")
	public String telaCadastro() {
		return "trapezista/cadastro";
	}	

	@GetMapping(value = "/trapezista/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("trapezistas", trapezistaService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "trapezista/lista";
	}
	
	@PostMapping(value = "/trapezista/incluir")
	public String incluir(Trapezista trapezista, @SessionAttribute("usuario") Usuario usuario) {
		
		trapezista.setUsuario(usuario);

		trapezistaService.incluir(trapezista);
		
		msg = "A inclusão da trapezista "+trapezista.getNome()+" foi realizada com sucesso!!!";
		
		return "redirect:/trapezista/lista";
	}
		
	@GetMapping(value = "/trapezista/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Trapezista trapezista = trapezistaService.obterPorId(id);
		
		trapezistaService.excluir(id);
		
		msg = "A exclusão da trapezista "+trapezista.getNome()+" foi realizada com sucesso!!!";

		return "redirect:/trapezista/lista";
	}
}

