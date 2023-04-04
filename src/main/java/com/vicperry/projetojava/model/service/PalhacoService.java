package com.vicperry.projetojava.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vicperry.projetojava.model.domain.Palhaco;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.PalhacoRepository;

@Service
public class PalhacoService {
	@Autowired
	private PalhacoRepository palhacoRepository;

	public Palhaco incluir(Palhaco palhaco) {
		return palhacoRepository.save(palhaco);
	}
	
	public void excluir(Integer id) {
		palhacoRepository.deleteById(id);
	}
	
	public Collection<Palhaco> obterLista(){
		return (Collection<Palhaco>) palhacoRepository.findAll();
	}
	
	public Collection<Palhaco> obterLista(Usuario usuario){
		return (Collection<Palhaco>) palhacoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Palhaco obterPorId(Integer id) {
		return palhacoRepository.findById(id).orElse(null);
	}
}
