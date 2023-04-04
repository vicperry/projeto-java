package com.vicperry.projetojava.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vicperry.projetojava.model.domain.Magico;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.MagicoRepository;

@Service
public class MagicoService {
	@Autowired
	private MagicoRepository magicoRepository;

	public Magico incluir(Magico magico) {
		return magicoRepository.save(magico);
	}
	
	public void excluir(Integer id) {
		magicoRepository.deleteById(id);
	}
	
	public Collection<Magico> obterLista(){
		return (Collection<Magico>) magicoRepository.findAll();
	}
	
	public Collection<Magico> obterLista(Usuario usuario){
		return (Collection<Magico>) magicoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Magico obterPorId(Integer id) {
		return magicoRepository.findById(id).orElse(null);
	}
}
