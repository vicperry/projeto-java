package com.vicperry.projetojava.model.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vicperry.projetojava.model.exception.ContratanteInvalidoException;

@Entity
@Table(name = "TContratante")
public class Contratante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String cpf;
	@ManyToOne
	@JoinColumn(name= "idUsuario")
	private Usuario usuario;
	@OneToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	public Contratante() {
	}
	
	public Contratante(String nome, String telefone, String cpf) throws ContratanteInvalidoException {
		this();
		
		if(nome == null) {
			throw new ContratanteInvalidoException("O contratante precisa ter um nome."); 
		}
		
		if(telefone == null) {
			throw new ContratanteInvalidoException("O contratante precisa ter um telefone para contato."); 
		}
		
		if(cpf == null) {
			throw new ContratanteInvalidoException("O contratante precisa ter um CPF."); 
		}
		
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome + ";");
		sb.append(cpf + ";");
		sb.append(telefone + ";");
		
		return sb.toString();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
