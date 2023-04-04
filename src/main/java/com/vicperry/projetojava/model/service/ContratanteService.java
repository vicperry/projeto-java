package com.vicperry.projetojava.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vicperry.projetojava.model.domain.Contratante;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.ContratanteRepository;

@Service
public class ContratanteService {
	@Autowired
	private ContratanteRepository contratanteRepository;
	
	public Contratante incluir(Contratante contratante) {
		return contratanteRepository.save(contratante);
	}
	
	public void excluir(Integer key) {
		contratanteRepository.deleteById(key);
	}
	
	public Collection<Contratante> obterLista(){
		return (Collection<Contratante>) contratanteRepository.findAll();
	}
	
	public Collection<Contratante> obterLista(Usuario usuario){
		return contratanteRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}
}
