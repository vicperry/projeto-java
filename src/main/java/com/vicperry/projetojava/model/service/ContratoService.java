package com.vicperry.projetojava.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicperry.projetojava.model.domain.Contrato;
import com.vicperry.projetojava.model.domain.Usuario;
import com.vicperry.projetojava.model.repository.ContratoRepository;

@Service
public class ContratoService {
	@Autowired
	private ContratoRepository contratoRepository;

	public Contrato incluir(Contrato contrato) {
		return contratoRepository.save(contrato);
	}
	
	public void excluir(Integer id) {
		contratoRepository.deleteById(id);
	}
	
	public Collection<Contrato> obterLista(){
		return (Collection<Contrato>) contratoRepository.findAll();
	}
	
	public Collection<Contrato> obterLista(Usuario usuario){
		return (Collection<Contrato>) contratoRepository.obterLista(usuario.getId());
	}

	public Contrato obterPorId(Integer id) {
		return contratoRepository.findById(id).orElse(null);
	}
}
