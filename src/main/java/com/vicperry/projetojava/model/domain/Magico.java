package com.vicperry.projetojava.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.vicperry.projetojava.model.exception.ArtistaInvalidoException;

@Entity
@Table(name = "TMagico")
public class Magico extends Artista {
	
	private boolean fazPirotecnia;
	private int numeroTruques;
	private boolean usaCoelho;
	
	public Magico(String nome, float salarioHora, String telefone) throws ArtistaInvalidoException {
		super(nome, salarioHora, telefone);
		// TODO Auto-generated constructor stub
	}

	public Magico() {
		// TODO Auto-generated constructor stub
	}
	
    @Override
    public float calcularValorHora() {
        float valorHora = salarioHora;
        
        if (fazPirotecnia) {
            valorHora *= 2;
        }
        
        return valorHora;
    }

	@Override
	public String toString() {
		return "Magico [fazPirotecnia=" + fazPirotecnia + ", numeroTruques=" + numeroTruques + ", usaCoelho="
				+ usaCoelho + "]";
	}

	public boolean isFazPirotecnia() {
		return fazPirotecnia;
	}

	public void setFazPirotecnia(boolean fazPirotecnia) {
		this.fazPirotecnia = fazPirotecnia;
	}

	public int getNumeroTruques() {
		return numeroTruques;
	}

	public void setNumeroTruques(int numeroTruques) {
		this.numeroTruques = numeroTruques;
	}

	public boolean isUsaCoelho() {
		return usaCoelho;
	}

	public void setUsaCoelho(boolean usaCoelho) {
		this.usaCoelho = usaCoelho;
	}
	
}
