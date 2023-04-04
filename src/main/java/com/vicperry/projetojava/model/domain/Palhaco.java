package com.vicperry.projetojava.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.vicperry.projetojava.model.exception.ArtistaInvalidoException;

@Entity
@Table(name = "TPalhaco")
public class Palhaco extends Artista {
	
	private int tamanhoSapato;
	private boolean humorAdulto;
	private String nomeArtistico;
	
	public Palhaco(String nome, float salarioHora, String telefone) throws ArtistaInvalidoException {
		super(nome, salarioHora, telefone);
		// TODO Auto-generated constructor stub
	}

	public Palhaco() {
		// TODO Auto-generated constructor stub
	}
	
	

    @Override
	public String toString() {
		return "Palhaco [tamanhoSapato=" + tamanhoSapato + ", humorAdulto=" + humorAdulto + ", nomeArtistico="
				+ nomeArtistico + ", id=" + id + ", nome=" + nome + ", salarioHora=" + salarioHora + ", telefone="
				+ telefone + "]";
	}

	@Override
    public float calcularValorHora() {
        float valorHora = salarioHora;
        
        if (humorAdulto) {
            valorHora *= 1.5;
        }
        
        return valorHora;
    }

	public int getTamanhoSapato() {
		return tamanhoSapato;
	}

	public void setTamanhoSapato(int tamanhoSapato) {
		this.tamanhoSapato = tamanhoSapato;
	}

	public boolean isHumorAdulto() {
		return humorAdulto;
	}

	public void setHumorAdulto(boolean humorAdulto) {
		this.humorAdulto = humorAdulto;
	}

	public String getNomeArtistico() {
		return nomeArtistico;
	}

	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
	}
	
	

}
