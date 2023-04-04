package com.vicperry.projetojava.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vicperry.projetojava.model.domain.Artista;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.ArtistaRepository;

@Service
public class ArtistaService {
	@Autowired
	private ArtistaRepository artistaRepository;

	public void excluir(Integer id) {
		artistaRepository.deleteById(id);
	}
	
	public Collection<Artista> obterLista(){
		return (Collection<Artista>) artistaRepository.findAll();
	}
	
	public Collection<Artista> obterLista(Usuario usuario){
		return (Collection<Artista>) artistaRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Artista obterPorId(Integer id) {
		return artistaRepository.findById(id).orElse(null);
	}
}
