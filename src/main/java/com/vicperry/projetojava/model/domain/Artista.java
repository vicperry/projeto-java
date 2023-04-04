package com.vicperry.projetojava.model.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vicperry.projetojava.model.exception.ArtistaInvalidoException;

@Entity
@Table(name = "TArtista")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nome;
	protected float salarioHora;
	protected String telefone;
	@ManyToOne
	@JoinColumn(name= "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy="artistas")
	private List<Contrato> contratos;
	
	
	public Artista(String nome, float salarioHora, String telefone) throws ArtistaInvalidoException {
		this();
		if(nome == null) {
			throw new ArtistaInvalidoException("Insira o nome do artista.");
		}
		if(salarioHora <= 0){
			throw new ArtistaInvalidoException("Insira um salário-hora válido.");
		}
		if(telefone == null) {
			throw new ArtistaInvalidoException("Insira um telefone de contato.");
		}
		this.nome = nome;
		this.salarioHora = salarioHora;
		this.telefone = telefone;
	}
	
	public abstract float calcularValorHora();
	
	public Artista() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getSalarioHoraa() {
		return salarioHora;
	}
	public void setSalarioHora(float salarioHora) {
		this.salarioHora = salarioHora;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getSalarioHora() {
		return salarioHora;
	}
	
}
