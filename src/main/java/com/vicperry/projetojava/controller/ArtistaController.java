package com.vicperry.projetojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.vicperry.projetojava.model.domain.Artista;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.ArtistaService;

@Controller
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaService;

	private String msg;
	
	@GetMapping(value = "/artista/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("artistas", artistaService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "artista/lista";
	}
	
	@GetMapping(value = "/artista/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Artista artista = artistaService.obterPorId(id);
		
		artistaService.excluir(id);
		
		msg = "A exclusão do artista "+artista.getNome()+" foi realizada com sucesso!!!";

		return "redirect:/artista/lista";
	}
	
}
