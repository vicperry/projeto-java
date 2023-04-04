package com.vicperry.projetojava.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.vicperry.projetojava.model.exception.ArtistaInvalidoException;

@Entity
@Table(name = "TTrapezista")
public class Trapezista extends Artista {
	
    private double altura;
    private int numeroAcrobaciasRealizadas;
    private boolean possuiRedeSegurança;

	public Trapezista(String nome, float salarioHora, String telefone) throws ArtistaInvalidoException {
		super(nome, salarioHora, telefone);
		// TODO Auto-generated constructor stub
	}

	public Trapezista() {
		// TODO Auto-generated constructor stub
	}

	  @Override
	    public float calcularValorHora() {
	        float valorHora = salarioHora;
	        
	        if (possuiRedeSegurança) {
	            valorHora *= 3;
	        }
	        
	        return valorHora;
	    }
	  
	  

	@Override
	public String toString() {
		return "Trapezista [altura=" + altura + ", numeroAcrobaciasRealizadas="
				+ numeroAcrobaciasRealizadas + ", possuiRedeSegurança=" + possuiRedeSegurança + "]";
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getNumeroAcrobaciasRealizadas() {
		return numeroAcrobaciasRealizadas;
	}

	public void setNumeroAcrobaciasRealizadas(int numeroAcrobaciasRealizadas) {
		this.numeroAcrobaciasRealizadas = numeroAcrobaciasRealizadas;
	}

	public boolean isPossuiRedeSegurança() {
		return possuiRedeSegurança;
	}

	public void setPossuiRedeSegurança(boolean possuiRedeSegurança) {
		this.possuiRedeSegurança = possuiRedeSegurança;
	}
	  
	  
	  
	  

}
