package com.vicperry.projetojava.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicperry.projetojava.client.IEnderecoClient;
import com.vicperry.projetojava.model.domain.Endereco;

@Service
public class EnderecoService {
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco buscaPorCep(String cep) {

		return enderecoClient.buscaPorCep(cep);
	}
}
