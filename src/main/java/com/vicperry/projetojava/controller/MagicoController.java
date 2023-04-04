package com.vicperry.projetojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.vicperry.projetojava.model.domain.Magico;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.MagicoService;

@Controller
public class MagicoController {
	@Autowired
	private MagicoService magicoService;

	private String msg;

	@GetMapping(value = "/magico")
	public String telaCadastro() {
		return "magico/cadastro";
	}	

	@GetMapping(value = "/magico/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("magicos", magicoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "magico/lista";
	}
	
	@PostMapping(value = "/magico/incluir")
	public String incluir(Magico magico, @SessionAttribute("usuario") Usuario usuario) {
		
		magico.setUsuario(usuario);

		magicoService.incluir(magico);
		
		msg = "A inclusão da mágico "+magico.getNome()+" foi realizada com sucesso!!!";
		
		return "redirect:/magico/lista";
	}
		
	@GetMapping(value = "/magico/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Magico magico = magicoService.obterPorId(id);
		
		magicoService.excluir(id);
		
		msg = "A exclusão da mágico "+magico.getNome()+" foi realizada com sucesso!!!";

		return "redirect:/magico/lista";
	}
}
