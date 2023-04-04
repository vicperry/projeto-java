package com.vicperry.projetojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.vicperry.projetojava.model.domain.Contrato;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.service.ArtistaService;
import com.vicperry.projetojava.model.service.ContratanteService;
import com.vicperry.projetojava.model.service.ContratoService;

@Controller
public class ContratoController {
	@Autowired
	private ContratoService contratoService;

	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private ContratanteService contratanteService;
	
	private String msg;

	@GetMapping(value = "/contrato")
	public String telaCadastro(Model model, @SessionAttribute("usuario") Usuario usuario) {
		model.addAttribute("contratantes", contratanteService.obterLista(usuario));
		
		model.addAttribute("artistas", artistaService.obterLista(usuario));

		return "contrato/cadastro";
	}	

	@GetMapping(value = "/contrato/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("contratos", contratoService.obterLista(usuario));
		
		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "contrato/lista";
	}
	
	@PostMapping(value = "/contrato/incluir")
	public String incluir(Contrato contrato, @SessionAttribute("usuario") Usuario usuario) {
		
		contrato.setUsuario(usuario);

		contratoService.incluir(contrato);
		
		msg = "A inclusão do contrato "+contrato.getDescricaoEvento()+" foi realizada com sucesso!!!";
		
		return "redirect:/contrato/lista";
	}
		
	@GetMapping(value = "/contrato/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		Contrato contrato = contratoService.obterPorId(id);
		
		contratoService.excluir(id);
		
		msg = "A exclusão do contrato "+contrato.getDescricaoEvento()+" foi realizada com sucesso!!!";

		return "redirect:/contrato/lista";
	}
}
