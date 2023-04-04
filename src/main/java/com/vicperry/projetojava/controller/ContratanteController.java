package com.vicperry.projetojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.vicperry.projetojava.model.domain.Contratante;
import com.vicperry.projetojava.model.domain.Endereco;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.ContratanteRepository;
import com.vicperry.projetojava.model.repository.UsuarioRepository;
import com.vicperry.projetojava.model.service.ContratanteService;

@Controller
public class ContratanteController {
	@Autowired
	private ContratanteService contratanteService;
	
	private String mensagem;

	@GetMapping("/contratante")
	public String getContratanteCadastro() {
		return "/contratante/cadastro";
	}

	@GetMapping("/contratante/lista")
	public String getContratanteLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		model.addAttribute("contratantes", contratanteService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		
		return "contratante/lista";
	}

	@PostMapping("/contratante/incluir")
	public String postCadastro(Contratante contratante, Endereco endereco, @SessionAttribute("usuario") Usuario usuario) {
		
		contratante.setUsuario(usuario);
		
		contratante.setEndereco(endereco);

		
		contratanteService.incluir(contratante);
		
		mensagem = "A inclusão do contratante "+contratante.getNome()+" foi realizada com sucesso!!!";


		return "redirect:/contratante/lista";
	}
	
	@GetMapping("/contratante/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		contratanteService.excluir(id);
		mensagem = "A exclusão do contratante "+ id +" foi realizada com sucesso!!!";
		return "redirect:/contratante/lista";
	}

}
