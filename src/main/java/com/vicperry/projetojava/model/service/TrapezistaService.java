package com.vicperry.projetojava.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vicperry.projetojava.model.domain.Trapezista;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.TrapezistaRepository;

@Service
public class TrapezistaService {
	@Autowired
	private TrapezistaRepository trapezistaRepository;

	public Trapezista incluir(Trapezista trapezista) {
		return trapezistaRepository.save(trapezista);
	}
	
	public void excluir(Integer id) {
		trapezistaRepository.deleteById(id);
	}
	
	public Collection<Trapezista> obterLista(){
		return (Collection<Trapezista>) trapezistaRepository.findAll();
	}
	
	public Collection<Trapezista> obterLista(Usuario usuario){
		return (Collection<Trapezista>) trapezistaRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Trapezista obterPorId(Integer id) {
		return trapezistaRepository.findById(id).orElse(null);
	}
}
