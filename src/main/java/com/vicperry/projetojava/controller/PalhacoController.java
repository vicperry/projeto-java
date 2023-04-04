package com.vicperry.projetojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.vicperry.projetojava.model.domain.Palhaco;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.PalhacoService;

@Controller
public class PalhacoController {
	@Autowired
	private PalhacoService palhacoService;

	private String msg;

	@GetMapping(value = "/palhaco")
	public String telaCadastro() {
		return "palhaco/cadastro";
	}	

	@GetMapping(value = "/palhaco/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("palhacos", palhacoService.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "palhaco/lista";
	}
	
	@PostMapping(value = "/palhaco/incluir")
	public String incluir(Palhaco palhaco, @SessionAttribute("usuario") Usuario usuario) {
		
		palhaco.setUsuario(usuario);

		palhacoService.incluir(palhaco);
		
		msg = "A inclusão da palhaco "+palhaco.getNome()+" foi realizada com sucesso!!!";
		
		return "redirect:/palhaco/lista";
	}
		
	@GetMapping(value = "/palhaco/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Palhaco palhaco = palhacoService.obterPorId(id);
		
		palhacoService.excluir(id);
		
		msg = "A exclusão da palhaco "+palhaco.getNome()+" foi realizada com sucesso!!!";

		return "redirect:/palhaco/lista";
	}
}
